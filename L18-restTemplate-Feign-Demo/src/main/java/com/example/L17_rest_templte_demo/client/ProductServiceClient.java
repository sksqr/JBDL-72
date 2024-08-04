package com.example.L17_rest_templte_demo.client;

import com.example.L17_rest_templte_demo.dto.BlogDto;
import com.example.L17_rest_templte_demo.dto.ProductDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(name = "products",url = "${product.service.baseUrl}")
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductServiceClient {

    @GetMapping("/product/{id}")
    ProductDto getProduct(@PathVariable Long id, @RequestHeader String requestId);

    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto productDto, @RequestHeader String requestId);

}
