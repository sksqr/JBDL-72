package com.example.L17_rest_templte_demo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy/product")
public class ProductProxyController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    ResponseEntity<JsonNode> createProductProxy(@RequestBody JsonNode jsonNode){
        String url = "http://localhost:8080/product";
        jsonNode = restTemplate.postForEntity(url,jsonNode,JsonNode.class).getBody();
        return ResponseEntity.ok(jsonNode);
    }
}
