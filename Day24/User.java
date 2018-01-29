package com.luiscasas;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;		
	
	private User(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.email = builder.email;
	}
	
	@Override 
	public String toString() {
		return "User Object [username: " + username + ", password: " + password +
				", firstname: " + firstname + ", lastname: " + lastname + ", email " + email;
	}
	
	public static class Builder{
		
		private String username;
		private String password;
		private String firstname;
		private String lastname;
		private String email;	
		
		public Builder(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
		public Builder firstname(String value) {
			this.firstname = value;
			return this;
		}
		
		public Builder lastname(String value) {
			this.lastname = value;
			return this;
		}
		
		public Builder email(String value) {
			this.email = value;
			return this;
		}			
		
		public User build() {
			return new User(this);
		}
	}
}
