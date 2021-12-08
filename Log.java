// This class creates a log of failed and passed password attempts
import java.io.File;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
=======
import java.io.FileWriter;
import java.io.IOException;

>>>>>>> eada6a20fb10c617f27ed2faee42580b849caff8
class Log{
	String this.filename;

	// Initializes the object and stores the filename
	public Log(String filename){
<<<<<<< HEAD
		File ;
=======
		this.filename = filename;
>>>>>>> eada6a20fb10c617f27ed2faee42580b849caff8
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