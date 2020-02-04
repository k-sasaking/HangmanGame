package hangman.model;

public class Hangman {
	
	int index;
	
	public static final String[] hangman = new String[] {
			"",
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	  |   |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	 /|   |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	 /|\\  |\r\n" + 
			"	      |\r\n" + 
			"	      |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	 /|\\  |\r\n" + 
			"	 /    |\r\n" + 
			"	     |\r\n" + 
			"	=========",
	
			"	  +---+\r\n" + 
			"	  |   |\r\n" + 
			"	  O   |\r\n" + 
			"	 /|\\  |\r\n" + 
			"	 / \\  |\r\n" + 
			"	      |\r\n" + 
			"	========="
	};
	
	public void view() {
		System.out.println(hangman[index]);
	}
	
	public boolean hasNext() {
		if(index==hangman.length-1) 
			return false;
		return true;
	}
	public String next() {
		index++;
		return this.hangman[index];
	}
	
	
//	public static final String[] hangman = new String[] {
//			"",
	
//			new StringBuffer()
//			.append("	  +---+\r\n")
//			.append("	  |   |\r\n")
//			.append("	      |\r\n")
//			.append("	      |\r\n")
//			.append("	      |\r\n")
//			.append("	      |\r\n")
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n")
//			.append("	  |   |\r\n")
//			.append("	  O   |\r\n")
//			.append("	      |\r\n")
//			.append("	      |\r\n") 
//			.append("	      |\r\n") 
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	  O   |\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	      |\r\n") 
//			.append("	      |\r\n") 
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	  O   |\r\n") 
//			.append("	 /|   |\r\n") 
//			.append("	      |\r\n") 
//			.append("	      |\r\n") 
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	  O   |\r\n") 
//			.append("	 /|\\  |\r\n") 
//			.append("	      |\r\n") 
//			.append("	      |\r\n") 
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	  O   |\r\n") 
//			.append("	 /|\\  |\r\n") 
//			.append("	 /    |\r\n") 
//			.append("	     |\r\n") 
//			.append("	=========")
//			.toString(),
//			
//			new StringBuffer()
//			.append("	  +---+\r\n") 
//			.append("	  |   |\r\n") 
//			.append("	  O   |\r\n") 
//			.append("	 /|\\  |\r\n") 
//			.append("	 / \\  |\r\n") 
//			.append("	      |\r\n") 
//			.append("	=========")
//			.toString()
//	};

}
