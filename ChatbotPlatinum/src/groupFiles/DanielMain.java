package groupFiles;

import java.util.Scanner;

public class DanielMain {
		
		static String response;
		static boolean inMainLoop;
		static Scanner input;
		static String user;
		// list all the chatbots available under this class
		//Add group chatbots below 
		//static Chatbot school;
		
	public static void main(String[] args) {
		createFields();
		promptName();
		//promptInput();
		promptForever();
	}
	
	public static void promptName() {
		print("Enter Your Name!");
		user = input.nextLine();
	}

	public static void promptForever() {
		inMainLoop = true;
		while(inMainLoop){
			print("Hi, "+user+". How are you?");
			response = promptInput();
			if(findKeyword(response, "good", 0) >= 0){
				print("That's wonderful. "+"So glad to feel good");
			}
//			else if(school.){
//				print("School is great. "+"Tell me about School.");
//				inMainLoop = false;
//				school.talk();
//			}
			else {
				print("I don't understand");
			}
		}
	}

	public static int findKeyword(String searchString, String keyword, int startpsn) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		System.out.println("The Phrase is "+searchString);
		System.out.println("The keyword is "+keyword);
		int psn = searchString.indexOf(0);
		System.out.println("The keyword was found at "+psn);
		
		while(psn >= 0){
			String before = " ";
			String after = " ";
			if(psn > 0){
				before = searchString.substring(psn-1, psn);
				System.out.println("The Character before is "+before);
			}
			if(psn+ keyword.length() < searchString.length()){
				after = searchString.substring(psn + keyword.length(), psn + keyword.length() + 1);                                            
				System.out.println("The Character after is "+after);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
				System.out.println("Found "+keyword+" at "+psn);
				return psn;
			}
			else{
				psn = searchString.indexOf(keyword,psn+1);
				System.out.print("Did not find "+keyword+", checking position "+psn);
			}
		}
		return -1;
	}

	/**
	 * Annotations
	 * Helper methods are private methods that are to be used in other methods, they make the code readable.
	 * READABLE
	 * @param searchString
	 * @param psn
	 * @return true if there is no negation words in front of psn
	 */
	private static boolean noNegations(String searchString, int psn) {
		if(psn - 3 >= 0  && searchString.substring(psn-3, psn).equals("no "))
		{
			return false;
		}
		if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("not "))
		{
			return false;
		}
		if(psn - 6 >= 0  && searchString.substring(psn-6, psn).equals("never "))
		{
			return false;
		}
		if(psn - 4 >= 0  && searchString.substring(psn-4, psn).equals("n't "))
		{
			return false;
		}
		return true;
		
	}

	public static String promptInput() {
		String userInput = input.nextLine();
		return userInput;
		
		
	}

	public static void createFields() {
		input =  new Scanner(System.in);
		user = "";
		//initialize group chatbots below
		//school = new DanielSchool();
	}
	
	public static void print(String s){
		 String printString = "";
		 int cutoff = 25;
		 //this while loop last as long as there are words left in the original String
		 while(s.length() > 0){

			 String currentCut = "";
			 String nextWord = "";
	
			 //while the current cut is still less than the line length 
			 //AND there are still words left to add
			 while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
	
				 //add the next word
				 currentCut += nextWord;
				 
				 //remove the word that was added from the original String
				 s = s.substring(nextWord.length());
				 
				 //identify the following word, exclude the space
				 int endOfWord = s.indexOf(" ");
		
				 //if there are no more spaces, this is the last word, so add the whole thing
				 if(endOfWord == -1) {
					 endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				 }
	
				 //the next word should include the space
				 nextWord = s.substring(0,endOfWord+1);
			 }
	
			 	printString +=currentCut+"\n";
	
			 }
			 	System.out.print(printString);
	}			
}
