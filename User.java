/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project User Info Constructor Class
*/

import java.time.Instant;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

class User{
	private String username;
	private String key;
	private int window=60;     // Time in seconds for the window where passcode is accepted
	public User next=null;

	// Simple Constructor
	// Helpful for testing and development
	public User(String inUsername, String inKey){
		this.username = inUsername;
		this.key = inKey;
	}

	// Constructor that parses input
	// Useful when reading from a file
	public User(String input){
		String[] output;
		output = input.split(",");
		this.username = output[0];
		this.key = output[1];
	}

	// Returns the username
	public String getUsername(){
		return this.username;
	}

	// Returns the OTP for this time period and the previous time period
	// out[0] = current code
	// out[1] = last code
	// https://www.geeksforgeeks.org/sha-256-hash-in-java/
	public int[] getOTP() throws NoSuchAlgorithmException
	{
		// Sets time until new code is generated
		long unixTime = Instant.now().getEpochSecond()/this.window;
		
		// Initializes and sets hash vairables (variables to hash)
		String toHash1 = unixTime+this.key;
		String toHash2 = (unixTime-1)+this.key;
		
		// Object to do the hashing
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		// Computes the hash
		byte[] hash1 = md.digest(toHash1.getBytes(StandardCharsets.UTF_8));
		byte[] hash2 = md.digest(toHash2.getBytes(StandardCharsets.UTF_8));

		// Converts the hash to an integer
		BigInteger num1 = new BigInteger(1, hash1);
		BigInteger num2 = new BigInteger(1, hash2);
		BigInteger divisor = BigInteger.valueOf(10000);

		// Converts the integer result to int type and puts in the output array
		int[] out = new int[2];
		out[0] = num1.mod(divisor).intValue();
		out[1] = num2.mod(divisor).intValue();

		return out;
	}

	public String toString(){
		return this.username;
	}
}