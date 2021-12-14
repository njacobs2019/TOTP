/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project Attempt Log Class
*/

// This class creates a log of failed and passed password attempts
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class Log{
	private String filename;

	// Initializes the object and stores the filename
	public Log(String filename){
		this.filename = filename;
	}

	// Adds a line to the log file recording that the
	// user entered the code correctly or incorrectly
	public void record(String username, String code, boolean correct){
		//Creates new file
		File new_f = new File(this.filename);
		try{
			//Creates file writer
			//True as a parameter allows FileWriter to append to file
			FileWriter w = new FileWriter(new_f, true);
			String s = "";

			//Records if user correctly entered their username and code
			if(correct){
				s = String.format("%s correctly entered %s\n",username, code);
				w.write(s);
			}

			//Records to file login attempts where passcode was incorrect
			else{
				s = String.format("%s incorrectly entered %s\n",username, code);
				w.write(s);
			}

			//Closes writer
			w.close();
		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

	// Adds a line to the log file recording that the user does not exist
	public void record(String username){
		File new_f = new File(this.filename);
		try{
			FileWriter w = new FileWriter(new_f);
			String s = "";
			
			//Records to file login attempts where username was incorrect
			s = String.format("%s was entered, but this user does not exist\n",username);
			w.write(s);
			w.close();
		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}
}