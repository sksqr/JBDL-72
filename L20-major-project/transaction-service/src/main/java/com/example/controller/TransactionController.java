package com.example.controller;

import com.example.dto.TxnRequestDto;
import com.example.service.TransactionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/transaction-service")
public class TransactionController {

    private static Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/txn")
    public ResponseEntity<String> initTransaction(@RequestBody @Valid TxnRequestDto txnRequestDto) throws ExecutionException, InterruptedException {
        LOGGER.info("Starting transaction : {}",txnRequestDto);
        String txnId = transactionService.initTransaction(txnRequestDto);
        return ResponseEntity.accepted().body(txnId);
    }

}
