package internship.demo.config;


import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;



@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}