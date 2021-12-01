//  This class needs a better description

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class App{
	public LinkedList myData;

	// Initializes myData and fills the linkedlist from the file
	// There will be one file for each instance of the App class
	// One instance of app class might be FB or Snap
	public App(String filename){
		this.myData = new LinkedList();

		File f = new File(filename);
		try{
			Scanner scan = new Scanner(f);
			String line;

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
	// Make sure to use exceptions, see the example in Main.java
	// If user DNE return null
	public String getCode(String username){
		return "";
	}

	//  Returns a boolean of whether or not the code is correct
	//  Accepts either the current code or the previous code
	// Make sure to use exceptions, see the example in Main.java
	public boolean verifyCode(String username, String attemptCode){
		return false;
	}
}