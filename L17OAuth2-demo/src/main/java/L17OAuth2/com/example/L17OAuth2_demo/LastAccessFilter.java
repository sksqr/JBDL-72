package L17OAuth2.com.example.L17OAuth2_demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.EnumUtils;

import java.io.IOException;
import java.util.Date;

@Component
public class LastAccessFilter extends HttpFilter {

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            OAuth2User auth2User =  (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(auth2User != null){
                String email = auth2User.getAttribute("email");
                MyUser myUser = myUserRepo.findByEmail(email);
                if(myUser == null){
                    String name = auth2User.getAttribute("name");
                    myUser = new MyUser();
                    myUser.setName(name);
                    myUser.setEmail(email);
                }
                myUser.setLastAccess(new Date());
                myUserRepo.save(myUser);
            }
        }
        catch (Exception e){

        }
        filterChain.doFilter(request,response);
    }
}
