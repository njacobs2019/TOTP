//  This class simulates the Google Authenticator app that runs on someone's phone
import java.uitl.Scanner;

class AuthenticatorApp(){

private static myApp = new App("people.csv");

public void UsernameInput(){
	Scanner s = new Scanner(System.in);
	// ask the user for their username
	System.out.print("Username: ");
	String nameInput = s.nextline();
	System.out.print("\n");
	// print off their codes for each App instance
	returnCode = getCode(nameInput);
	s.close();
}
	public static void main(String[] args){
		// have user input loop
		Scanner scan = new Scanner(System.in);
		String returnCode = null;
		UsernameInput();
		While(returnCode = null){
			
			UsernameInput();
		}
		//   Print off latest codes, else quit the program (Y/N)

	}

}