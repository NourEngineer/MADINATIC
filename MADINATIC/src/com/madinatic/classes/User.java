package com.madinatic.classes;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class User {
	private String username;
	private String password;
	private Date date_create;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
	private final static int passwordLength = 10;
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
    public static String generatePassword() {
    	int length = passwordLength;
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String username() {
		return "";
	}

	public void setDate_create(Date date) {
		// TODO Auto-generated method stub
		
	}

}
