//  This class simulates the Google Authenticator/2FA web interface

class AuthenticatorServer(){
	public static void main(String[] args){}

	// **if the user types "quit" at any input quit the program**

	// In a loop:
	//		ask user for their username
	//			if doesn't exist, tell them and ask for it again
	//		ask for code
	//			verify code and update the log, if code is incorrect
	//			ask for it again

	App myApp = new App("people.csv");
	String user = "";
	String code = "";
}