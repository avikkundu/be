package internship.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import internship.demo.model.User;
import internship.demo.security.JwtUtil;
import internship.demo.service.UserService;
import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

	@Autowired
    private  UserService service;


    @PostMapping("/register")
    public String register(@RequestBody User user) {
    	System.out.println("adding user");
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user.getUsername(), user.getPassword());
    }
}
