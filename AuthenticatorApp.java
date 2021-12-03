//  This class simulates the Google Authenticator app that runs on someone's phone
import java.util.Scanner;

class AuthenticatorApp{

private static App myApp = new App("people.csv");

	public static void UsernameInput(){
		Scanner s = new Scanner(System.in);
		// ask the user for their username
		System.out.print("Username: ");
		String nameInput = s.nextLine();
		System.out.print("\n");
		// print off their codes for each App instance
		String returnCode = myApp.getCode(nameInput);
		s.close();
		}

	public static void rerun(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Invalid Input. Type Y to try again or N to exit.");
		String retry = scan.nextLine();
		if(retry.equals("Y")){
			UsernameInput();
		}
		if(retry.equals("N")){
			return;
		}
		else{
			rerun();
		}
	}
	public static void main(String[] args){
		// have user input loop
		String returnCode = null;
		String retry = "Y";
		UsernameInput();
		while(returnCode.equals(null) && retry.equals("Y")){
			rerun();
		}
		//   Print off latest codes, else quit the program (Y/N)

	}

}