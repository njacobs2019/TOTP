/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project App Side Constructor
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

class App{
	//Initializes linked list
	private LinkedList myData;

	// Initializes myData and fills the linkedlist from the file
	// There will be one file for each instance of the App class
	// One instance of app class might be FB or Snap
	public App(String filename){
		//Creates linked list
		this.myData = new LinkedList();

		//Initializes file reader
		File f = new File(filename);
		//Try catch in case the file the program reads from is invalid in any way.
		try{
			Scanner scan = new Scanner(f);
			String line;
			//Reads through the file that stores all the usernames and adds the usernames to the linked list
			while(scan.hasNext()){
				line = scan.nextLine();
				this.myData.add(new User(line));
			}
			scan.close();
		}
		catch(FileNotFoundException e){
			System.out.format("The file \"%s\" was not found.\n", filename);
		}
	}

	// Returns the code for the given user
	// If user DNE return null
	public String getCode(String username){
		User temp = myData.search(username);

		//Returns null if user inputs a username that does not exist in the linked list
		if (temp==null){
			return null;
		}

		//If username exists, one time passcode is generated
		String out = "";
		try{
			out += temp.getOTP()[0];
		}
		catch (NoSuchAlgorithmException e){
			System.out.println("Your machine does not support SHA-256.");
		}

		return out;  // Returns OTP
	}

	//  Returns a boolean of whether or not the code is correct
	//  Accepts either the current code or the previous code
	public boolean verifyCode(String username, String attemptCode){
		User temp = myData.search(username);

		//Returns false if user inputs an incorrect username
		if (temp==null){
			return false;
		}

		String out0 = "";
		String out1 = "";
		try{
			//Code allows either the current or immediately previous generated code as answers
			out0 += temp.getOTP()[0];
			out1 += temp.getOTP()[1];
			
			//Returns true if user enters one of the two codes that are correct at that time
			return out0.equals(attemptCode) || out1.equals(attemptCode);
		}
		catch (NoSuchAlgorithmException e){
			System.out.println("Your machine does not support SHA-256.");
		}
		//Returns false if user enters unacceptable code
		return false;
	}
}