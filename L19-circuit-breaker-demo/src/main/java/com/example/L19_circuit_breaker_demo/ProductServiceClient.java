package com.example.L19_circuit_breaker_demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "products",url = "${product.service.baseUrl}")
public interface ProductServiceClient {

    @GetMapping("/product/{id}")
    ProductDto getProduct(@PathVariable Long id, @RequestHeader String requestId);

    @PostMapping("/product")
    ProductDto createProduct(@RequestBody ProductDto productDto, @RequestHeader String requestId);

}
