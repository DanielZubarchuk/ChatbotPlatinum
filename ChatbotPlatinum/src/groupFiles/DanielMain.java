package groupFiles;

import java.util.Scanner;

public class DanielMain {
		
		static String response;
		static boolean inMainLoop;
		static Scanner input;
		static String user;
		
		static Chatbot daniel;
		
	public static void main(String[] args) {
		createFields();
		promptName();
		//promptInput();
		promptForever();
	}
	
	public static void promptName() {
		print("Welcome, Please Enter Your Name!");
		user = input.nextLine();
	}

	public static void promptForever() {
		inMainLoop = true;
		while(inMainLoop){
			print("Hi, "+user+".We are going to play a game! I will ask you questions and you will have to guess the answers!");
			response = promptInput();
//			daniel.talk();
			if(findKeyword(response, "good", 0) >= 0){
				print("That's wonderful. "+"So glad to feel good");
			}
			else {
				print("I don't understand");
				
			}
		}
	}

	public static int findKeyword(String searchString, String keyword, int startpsn) {
		searchString = searchString.trim();
		searchString = searchString.toLowerCase();
		keyword = keyword.toLowerCase();
		int psn = searchString.indexOf(0);
		
		
		while(psn >= 0){
			String before = " ";
			String after = " ";
			if(psn > 0){
				before = searchString.substring(psn-1, psn);
			}
			if(psn+ keyword.length() < searchString.length()){
				after = searchString.substring(psn + keyword.length(), psn + keyword.length() + 1);                                            
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, psn)){
				return psn;
			}
			else{
				psn = searchString.indexOf(keyword,psn+1);
			}
		}
		return -1;
	}
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
		daniel = new DanielClass();
		user = "";
	}
	
	public static void print(String s){
		 String printString = "";
		 int cutoff = 25;
	
		 while(s.length() > 0){

			 String currentCut = "";
			 String nextWord = "";
	
			 while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
	
				 currentCut += nextWord;
				 
				 s = s.substring(nextWord.length());
				 
				 int endOfWord = s.indexOf(" ");
	
				 if(endOfWord == -1) {
					 endOfWord = s.length()-1;
				 }
				 nextWord = s.substring(0,endOfWord+1);
			 }
	
			 	printString +=currentCut+"\n";
	
			 }
			 	System.out.print(printString);
	}			
}