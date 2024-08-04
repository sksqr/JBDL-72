package com.example.L17_rest_templte_demo;


import com.example.L17_rest_templte_demo.client.BlogServiceClient;
import com.example.L17_rest_templte_demo.dto.BlogDto;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BlogServiceClient blogServiceClient;

//    @GetMapping("/{id}")
//    public ResponseEntity<JsonNode> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        JsonNode response  = restTemplate.getForObject(url,JsonNode.class);
//        return ResponseEntity.ok(response);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<BlogDto> getBlog(@PathVariable Long id){
//        String url = "https://jsonplaceholder.typicode.com/posts/"+id;
//        BlogDto response  = restTemplate.getForObject(url,BlogDto.class);
        BlogDto response  = blogServiceClient.getBlog(id);
        response.setServerDateTime(new Date());
        return ResponseEntity.ok(response);
    }



}
/*
jsonplaceholder 100 API call => 10 INR
1000 API => 100 INR

Daily API calls 1,00,000 => 10,000 INR
50K duplicate Caching ==> 5,000 INR

 */
