package com.example.demo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	 private static final List<User> USERS_LIST = new ArrayList<>();

	    public void register(User user) {
	        user.setStatus("online");
	        USERS_LIST.add(user);
	    }

	    public User login(User user) {
	        var userIndex = IntStream.range(0, USERS_LIST.size())
	                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("User not Found"));

	        var cUser = USERS_LIST.get(userIndex);

	        if (!cUser.getPassword().equals(user.getPassword())) {
	            throw new RuntimeException("Password incorrect");
	        }

	        cUser.setStatus("online");
	        return cUser;
	    }

	    public void logout(String email) {
	        var userIndex = IntStream.range(0, USERS_LIST.size())
	                .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("User not Found"));

	        USERS_LIST.get(userIndex).setStatus("offline");
	    }

	    public List<User> findAll() {
	        return USERS_LIST;
	    }
}
