// This class manages the linked list of users

class LinkedList{
	private User head;
	private User tail;

	// Constructor
	public LinkedList(){
		head = null;
		tail = null;
	}

	// Adds a user to the list
	public void add(User input){
		if head==null{
			this.head=input;
			this.tail=input;
		}
		else{
			this.tail.next = input;
			this.tail = this.tail.next;
		}
	}

	// Returns a user object after searching by username
	// else, returns null
	public User search(String username){
		for(User temp=head; temp!=null; temp=temp.next){
			if temp.getUsername().equals(username){
				return temp;
			}
		}
		return null;
	}

	// Converts the list to a string for printing and debugging
	public String toString(){
		String out = "";
		for(User temp=head; temp!=null; temp=temp.next){
			out += "[";
			out += temp.toString;
			out += "]";
		}
		return out;
	}
}