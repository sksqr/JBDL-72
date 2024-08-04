package com.example.L17_rest_templte_demo.client;
import com.example.L17_rest_templte_demo.dto.BlogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "blogs",url = "https://jsonplaceholder.typicode.com/posts")
public interface BlogServiceClient {

    @GetMapping("/{id}")
    BlogDto getBlog(@PathVariable Long id);

}
