package com.example.L17_rest_templte_demo;

import com.example.L17_rest_templte_demo.client.ProductServiceClient;
import com.example.L17_rest_templte_demo.dto.ProductDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy/product")
public class ProductProxyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductServiceClient productServiceClient;

    @PostMapping
    ResponseEntity<ProductDto> createProductProxy(@RequestBody ProductDto productDto, @RequestHeader String requestId){
        //MDC.put("requestId",requestId);
        LOGGER.info("Calling actual ProductApp to create Product");
//        String url = "http://localhost:8080/product";
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("requestId",requestId);
//        HttpEntity<JsonNode> entity = new HttpEntity<>(jsonNode, headers);
//        jsonNode = restTemplate.postForObject(url, entity, JsonNode.class);
        ProductDto product = productServiceClient.createProduct(productDto, requestId);
        LOGGER.info("Returning final response");
        return ResponseEntity.ok(product);
    }


    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductProxy(@PathVariable Long id){
        LOGGER.info("Calling actual ProductApp to get a Product");
//        String url = "http://localhost:8080/product/"+id;
//        JsonNode jsonNode = restTemplate.getForObject(url,JsonNode.class);
        String requestId = MDC.get("requestId");
        ProductDto productDto = productServiceClient.getProduct(id,requestId);
        LOGGER.info("Returning final response of get Product");
        return ResponseEntity.ok(productDto);
    }
}
