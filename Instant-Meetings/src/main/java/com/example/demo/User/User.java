package com.example.demo.User;

public class User {

	  private String username;
	    private String email;
	    private String password;
	    private String status;
	    

	    // No-argument constructor
	    public User() {
	    }

	    private User(Builder builder) {
	        this.username = builder.username;
	        this.email = builder.email;
	        this.password = builder.password;
	        this.status = builder.status;
	    }

	    public static Builder builder() {
	        return new Builder();
	    }

	    public static class Builder {
	        private String username;
	        private String email;
	        private String password;
	        private String status;

	        public Builder username(String username) {
	            this.username = username;
	            return this;
	        }

	        public Builder email(String email) {
	            this.email = email;
	            return this;
	        }

	        public Builder password(String password) {
	            this.password = password;
	            return this;
	        }

	        public Builder status(String status) {
	            this.status = status;
	            return this;
	        }

	        public User build() {
	            return new User(this);
	        }
	    }

	    // Getters and setters
	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
