package L17OAuth2.com.example.L17OAuth2_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long> {
    MyUser findByEmail(String email);
}
