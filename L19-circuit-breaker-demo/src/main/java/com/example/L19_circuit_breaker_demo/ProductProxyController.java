package com.example.L19_circuit_breaker_demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/proxy/product")
public class ProductProxyController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductProxyController.class);

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;


    @PostMapping
    ResponseEntity<ProductDto> createProductProxy(@RequestBody ProductDto productDto){
        LOGGER.info("Calling actual ProductApp to create Product");
        String requestId="1234";
        ProductDto product = productServiceClient.createProduct(productDto, requestId);
        LOGGER.info("Returning final response");
        return ResponseEntity.ok(product);
    }


    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getProductProxy(@PathVariable Long id){
        LOGGER.info("Calling actual ProductApp to get a Product");
        String requestId = MDC.get("requestId");
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("cb01");
        ProductDto productDto = circuitBreaker.run(() -> productServiceClient.getProduct(id,requestId), throwable -> fallbackMethodForGetProduct());
        //ProductDto productDto = productServiceClient.getProduct(id,requestId);
        LOGGER.info("Returning final response of get Product");
        return ResponseEntity.ok(productDto);
    }

    public ProductDto fallbackMethodForGetProduct(){
        return new ProductDto(1l,"Dummy Product", 1000.00);
    }
}
