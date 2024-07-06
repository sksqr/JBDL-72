package com.example.L09_JDBC_demo.controller;

import com.example.L09_JDBC_demo.entity.Product;
import com.example.L09_JDBC_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        if(id<1){
            return ResponseEntity.badRequest().build();
        }
        Product product = productService.getById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody Product product) throws URISyntaxException {
        product = productService.create(product);
        URI uri = new URI("http://localhost:8080/product/"+product.getId());
        return ResponseEntity.created(uri).build();
    }

//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
//        product = productService.create(product);
//        return ResponseEntity.ok(product);
//    }

//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws URISyntaxException {
//        productService.create(product);
//        return ResponseEntity.noContent().build();
//    }

//    @PostMapping
//    public ResponseEntity<AppResponse<Product>> createProductCustomMethod(@RequestBody Product product) throws URISyntaxException {
//        product = productService.create(product);
//        AppResponse<Product> appResponse = new AppResponse<>();
//        appResponse.setResponse(product);
//        appResponse.setErrorMessage("Some Error");
//        appResponse.setErrorCode(2132);
//        return ResponseEntity.ok(appResponse);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updatedProduct = productService.update(id,product);
        if(updatedProduct==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id){
        Product deletedProduct = productService.delete(id);
        if(deletedProduct==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedProduct);
    }

}
