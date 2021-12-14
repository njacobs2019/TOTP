/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project Authenticator App Main File
*/

import java.util.Scanner;

//  This class simulates the Google Authenticator app that runs on someone's phone
//  Calls App class and creates App variable to store all the usernames from the storage file
class AuthenticatorApp{

	private static App myApp = new App("people.csv");

	public static void main(String[] args){
		
		String returnCode = null;
		String retry = "Y";
		Scanner s = new Scanner(System.in);

		// Ask the user for their username
		System.out.print("Username: ");
		String nameInput = s.nextLine();
		
		// Print off their codes for each App instance
		returnCode = myApp.getCode(nameInput);
		if(returnCode != null){
			System.out.format("Code:  %s\n",returnCode);
		}

		// While loop is entered if user inputs an incorrect username
		while(returnCode == null && retry.equals("Y")){
			//Asks user if they would like to try signing in again
			System.out.print("\nInvalid Input. Type Y to try again or N to exit. ");
			retry = s.nextLine();

			// Asks again for username if user enters Y
			if(retry.equals("Y")){
				System.out.print("Username: ");
				nameInput = s.nextLine();
				returnCode = myApp.getCode(nameInput);

				//Prints code if user answers correctly
				if(returnCode != null){
					System.out.format("Code:  %s\n",returnCode);
				}
				//If user answers incorrectly again then return code = null which returns to the beginning of the while loop
			}

			//Exits program if user enters N
			else if(retry.equals("N")){
				return;
			}
			//Returns to beginning of while loop if user inputs an invalid answer to try again question
			else{
				returnCode = null;
				retry = "Y";
			}
		}
	}
}