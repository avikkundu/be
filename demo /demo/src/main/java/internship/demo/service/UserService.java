package internship.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import internship.demo.model.User;
import internship.demo.repo.UserRepository;
import internship.demo.security.JwtUtil;
import lombok.RequiredArgsConstructor;


@Service
public class UserService {
    
	@Autowired
    private  UserRepository userRepo;
	
	@Autowired
    private PasswordEncoder encoder;
	
	@Autowired
    private  JwtUtil jwtUtil;

    public UserService(UserRepository userRepo, PasswordEncoder encoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
    }

    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
        return "User registered";
    }

    public String login(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(username);
    }
}