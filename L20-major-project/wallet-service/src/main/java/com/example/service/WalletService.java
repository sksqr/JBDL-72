package com.example.service;

import com.example.TxnCompletedPayload;
import com.example.TxnInitPayload;
import com.example.entity.Wallet;
import com.example.repo.WalletRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class WalletService {

    private static Logger LOGGER = LoggerFactory.getLogger(WalletService.class);

    @Autowired
    private WalletRepo walletRepo;

    @Value("${txn.completed.topic}")
    private String txnCompletedTopic;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Transactional
    public void wallerTxn(TxnInitPayload txnInitPayload) throws ExecutionException, InterruptedException {

        //txnInitPayload.
        Wallet fromWallet = walletRepo.findByUserId(txnInitPayload.getFromUserId());
        TxnCompletedPayload txnCompletedPayload = TxnCompletedPayload.builder()
                .id(txnInitPayload.getId())
                .requestId(txnInitPayload.getRequestId())
                .build();
        if(fromWallet.getBalance() < txnInitPayload.getAmount()){
            txnCompletedPayload.setSuccess(false);
            txnCompletedPayload.setReason("Low Balance");
        }
        else {
            Wallet toWallet = walletRepo.findByUserId(txnInitPayload.getToUserId());
            fromWallet.setBalance(fromWallet.getBalance() - txnInitPayload.getAmount());
            toWallet.setBalance(toWallet.getBalance() + txnInitPayload.getAmount());
            txnCompletedPayload.setSuccess(true);
        }
        Future<SendResult<String,Object>> future  = kafkaTemplate.send(txnCompletedTopic,txnInitPayload.getFromUserId().toString(),txnCompletedPayload);
        LOGGER.info("Pushed TxnCompleted to kafka: {}",future.get());
    }
}
