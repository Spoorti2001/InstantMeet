package com.example.demo.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

	 private final UserService service;

	    // Manually defined constructor for dependency injection
	    public UserController(UserService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public ResponseEntity<String> register(@RequestBody User user) {
	        service.register(user);
	        return ResponseEntity.ok("User registered successfully");
	    }

	    @PostMapping("/login")
	    public ResponseEntity<User> login(@RequestBody User user) {
	        User loggedInUser = service.login(user);
	        return ResponseEntity.ok(loggedInUser);
	    }

	    @PostMapping("/logout")
	    public ResponseEntity<String> logout(@RequestBody User user) {
	        service.logout(user.getEmail());
	        return ResponseEntity.ok("User logged out successfully");
	    }

	    @GetMapping
	    public List<User> findAll() {
	        return service.findAll();
	    }


	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handle(Exception ex) {
	        ex.printStackTrace();
	        return ResponseEntity
	                .status(INTERNAL_SERVER_ERROR)
	                .body(ex.getMessage());
	    }
}
