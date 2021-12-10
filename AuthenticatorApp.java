//  This class simulates the Google Authenticator app that runs on someone's phone
import java.util.Scanner;

class AuthenticatorApp{

private static App myApp = new App("people.csv");

	public static void main(String[] args){
		// have user input loop
		String returnCode = null;
		String retry = "Y";
		Scanner s = new Scanner(System.in);
		// ask the user for their username
		System.out.print("Username: ");
		String nameInput = s.nextLine();
		System.out.print("\n");
		//System.out.println(myApp.myData);
		// print off their codes for each App instance
		returnCode = myApp.getCode(nameInput);
		if(returnCode != null){
			System.out.println(returnCode);
		}
		while(returnCode == null && retry.equals("Y")){
			System.out.print("invalid Input. Type Y to try again or N to exit. ");
			retry = s.nextLine();
			System.out.print("\n");
			if(retry.equals("Y")){
				System.out.print("Username: ");
				nameInput = s.nextLine();
				System.out.print("\n");
				returnCode = myApp.getCode(nameInput);
				if(returnCode != null){
					System.out.println(returnCode);
				}
			}
			else if(retry.equals("N")){
				return;
			}
			else{
				returnCode = null;
				retry = "Y";
			}
		}
		//   Print off latest codes, else quit the program (Y/N)
	}

}