/*
Nicholas Jacobs & Nate Roberts
12/14/21
Section 0001
Final Project Linked List Class
*/

// This class manages the linked list of users

class LinkedList{
	//Creates head and tail of Linked List
	private User head;
	private User tail;

	//Constructor sets both to null
	public LinkedList(){
		head = null;
		tail = null;
	}

	// Adds a user to the list
	public void add(User input){
		//If parameters used when adding the first piece of data to the linked list
		if (head==null){
			this.head=input;
			this.tail=input;
		}

		//Adds to list that already has data and sets tail to the new end of the list
		else{
			this.tail.next = input;
			this.tail = this.tail.next;
		}
	}

	// Returns a user object after searching by username
	// else, returns null
	public User search(String username){
		//replaceAll removes all non printable characters
		username = username.replaceAll("\\P{Print}","");
		
		for(User temp=head; temp!=null; temp=temp.next){
			//Returns the username if input username exists
			//.equals makes the parameter a boolean and equals true if username exists
			if (temp.getUsername().replaceAll("\\P{Print}","").equals(username)){
				return temp;
			}
		}
		//If username is invalid, for loop exists and null is returned
		return null;
	}

	// Converts the list to a string for printing and debugging
	public String toString(){
		String out = "";
		for(User temp=head; temp!=null; temp=temp.next){
			out += "[";
			out += temp.toString();
			out += "]\n";
		}
		return out;
	}
}