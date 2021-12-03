// This class is only for testing purposes and was used to test the user object
// test
// new comment



import java.security.NoSuchAlgorithmException;

class Main{
	//System.out.println("This is a test");
	public static void main(String[] args){
		User nick = new User("Nicholas","winston");
		//System.out.println(nick.getUsername());

		try{
			nick.getOTP();
			System.out.println("---");
		}
		catch (NoSuchAlgorithmException e){
			System.out.println("Your machine does not support SHA-256.");
		}
	}
}