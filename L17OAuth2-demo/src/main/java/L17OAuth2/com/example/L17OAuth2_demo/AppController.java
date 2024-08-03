package L17OAuth2.com.example.L17OAuth2_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello")
    public String getHello(){
        LOGGER.info("Processing Hello API");
        return "Hello from :"+Thread.currentThread().getName();
    }

    @GetMapping("/user")
    public Map<String,Object> user(){
        LOGGER.info("Processing USER API");
        OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String,Object> userDetail = new HashMap<>();
        userDetail.put("name",user.getAttributes().get("name"));
        userDetail.put("company",user.getAttributes().get("company"));
        return userDetail;
    }


    @GetMapping("/user-details")
    public Map<String,Object> userDetails(){
        LOGGER.info("Processing USER DETAILS API");
        OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getAttributes();
    }

}
