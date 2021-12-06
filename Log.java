// This class creates a log of failed and passed password attempts
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Log{
	String this.filename;

	// Initializes the object and stores the filename
	public Log(String filename){
		this.filename = filename;
	}

	// Adds a line to the log file recording that the
	// user entered the code correctly or incorrectly
	public void record(String username, String code, boolean correct){
		File new_f = new File(this.filename);
		try{
			FileWriter w = new FileWriter(new_f);
			String s = "";

			if(correct){
				s = String.format("%s correctly entered %s\n",username, code);
				w.write(s);
			}
			else{
				s = String.format("%s incorrectly entered %s\n",username, code);
				w.write(s);
			}
			
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

			s = String.format("%s was enerted, but this user does not exist\n",username);
			w.write(s);
			w.close();
		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}
}