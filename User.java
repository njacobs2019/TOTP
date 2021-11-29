import java.time.Instant;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

class User{
	private String username;
	private String key;
	private int window=10;     // Time in seconds for the window

	public User(String input){
		String[] output;
		output = input.split(",");
		this.username = output[0];
		this.key = output[1];
	}

	// Helpful for testing and development
	public User(String inUsername, String inKey){
		this.username = inUsername;
		this.key = inKey;
	}

	public String getUsername(){
		return this.username;
	}

	// Returns the OTP for this time period and the previous time period
	// out[0] = current code
	// out[1] = last code
	// https://www.geeksforgeeks.org/sha-256-hash-in-java/
	public int[] getOTP() throws NoSuchAlgorithmException
	{
		long unixTime = Instant.now().getEpochSecond()/this.window;

		String toHash1 = unixTime+this.key;
		String toHash2 = (unixTime-1)+this.key;
		
		// Object to do the hashing
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] hash1 = md.digest(toHash1.getBytes(StandardCharsets.UTF_8));
		byte[] hash2 = md.digest(toHash2.getBytes(StandardCharsets.UTF_8));

		BigInteger num1 = new BigInteger(1, hash1);
		BigInteger num2 = new BigInteger(1, hash2);
		BigInteger divisor = BigInteger.valueOf(10000);

		int[] out = new int[2];
		out[0] = num1.mod(divisor).intValue();
		out[1] = num2.mod(divisor).intValue();

		System.out.println(out[0]);
		System.out.println(out[1]);

		return out;
	}
}