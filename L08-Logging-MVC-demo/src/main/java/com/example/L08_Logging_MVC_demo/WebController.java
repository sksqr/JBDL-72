package com.example.L08_Logging_MVC_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {
    private static Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @GetMapping("/dynamic-list")
    public ModelAndView getList(){

        LOGGER.info("Processing dynamic-list");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1l,"laptop",500000.00));
        productList.add(new Product(2l,"mouse",500.00));
        ModelAndView modelAndView = new ModelAndView("dynamic-page.html");
        modelAndView.getModelMap().put("products",productList);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        modelAndView.getModelMap().put("serverTime",dateFormat.format(new Date()));
        return modelAndView;
    }


    @GetMapping("/products")
    @ResponseBody
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1l, "laptop", 500000.00));
        productList.add(new Product(2l, "mouse", 500.00));
        return productList;
    }
}
