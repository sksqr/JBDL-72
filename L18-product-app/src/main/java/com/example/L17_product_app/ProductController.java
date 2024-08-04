package com.example.L17_product_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestHeader String requestId){
        //MDC.put("requestId",requestId);
        LOGGER.info("Processing createProduct Req: {}",product);
        product = productService.createProduct(product);
        LOGGER.info("Created Product");
        return ResponseEntity.ok(product);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        LOGGER.info("Processing getProduct Req: {}",id);
        Product product = productService.getProduct(id);
        LOGGER.info("Returning final response");
        return ResponseEntity.ok(product);
    }
}
