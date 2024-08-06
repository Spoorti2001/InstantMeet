package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.User.User;
import com.example.demo.User.UserService;
@SpringBootApplication
public class InstantMeetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstantMeetingsApplication.class, args);
	}

	 @Bean
	    public CommandLineRunner commandLineRunner(UserService service) {
	        return args -> {
	            service.register(User.builder()
	                    .username("Spoorti")
	                    .email("spoorti@gmail.com")
	                    .password("spoorti")
	                    .build());

	        };
	    }
}
