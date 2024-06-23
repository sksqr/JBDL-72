package com.example.L08_Logging_MVC_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired(required = false)
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProdById(id);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/search")
    public List<Product> getProductById(@RequestParam String keyword){
        return productService.searchProduct(keyword);
    }

}
