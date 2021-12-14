/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project Site Side Main File
*/

//  This class simulates the Google Authenticator/2FA web interface
import java.util.Scanner;

class AuthenticatorServer{
	public static void main(String[] args){
		// **if the user types "quit" at any input quit the program**

		// In a loop:
		//		ask user for their username
		//			if doesn't exist, tell them and ask for it again
		//		ask for code
		//			verify code and update the log, if code is incorrect
		//			ask for it again

		App myApp = new App("people.csv");
		Log l = new Log("otp_log.txt");
		Scanner s = new Scanner(System.in);

		String user = "";
		String code = "";
		boolean flag = false;    //Did the user enter the correct code?
		String retry = "";

		do{
			System.out.print("\nEnter the username:  ");
			user = s.nextLine();
			System.out.print("Enter the code:  ");
			code = s.nextLine();
			flag = myApp.verifyCode(user,code);
			l.record(user,code,flag);
			if(flag==false){
				System.out.println("Incorrect credentials");
				System.out.println("Would you like to try again?");
				System.out.print("Enter Y/N:  ");
				retry = s.nextLine();
			}
		}while(flag==false && retry.equals("Y"));

		if(flag){
			System.out.println("You sucessfully logged in!");
		}
	}
}