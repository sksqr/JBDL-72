package com.example;

import com.example.dto.AddMoneyRequest;
import com.example.dto.AddMoneyResponse;
import com.example.dto.PGPaymentStatusDTO;
import com.example.entity.Wallet;
import com.example.repo.AddMoneyPaymentRepo;
import com.example.repo.WalletRepo;
import com.example.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wallet-service")
public class WalletController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private WalletService walletService;


    @PostMapping("/add-money")
    public ResponseEntity<AddMoneyResponse> addMoney(@RequestBody AddMoneyRequest addMoneyRequest){
        addMoneyRequest.setMerchantId(1l);
        AddMoneyResponse addMoneyResponse = restTemplate.postForObject("http://localhost:9090/pg-service/init-payment", addMoneyRequest, AddMoneyResponse.class);
        return ResponseEntity.ok(addMoneyResponse);
    }

    @GetMapping("/add-money-status/{pgTxnId}")
    public ResponseEntity<String> addMoneyStatus(@PathVariable String pgTxnId){
        return ResponseEntity.ok(walletService.processPgTxnId(pgTxnId));
    }
}
