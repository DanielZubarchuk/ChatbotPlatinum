package groupFiles;

public class DanielClass implements Chatbot{

	private String helloResponse;
	private boolean inHelloLoop;
	
	
	//private String[] calmResponses = 
	//	{"We aready said Hello.Lets move the conversation along.",
	//			"You said hello already. Did you forget?"};
	
	//private String[] angryResponses = 
		//{"Okay seriously, stop saying hello",
		//		"What is wrong with you and saying hello?"};
	
	private String[] cpuQuestions = 
		{"What Color Am I Thinking Of?", "What Animal Am I Thinking Of?", "What Number Am I Thinking Of?(Between 1 and 10)", "What is my favorite food?", "What is my favorite Sport?"};
	
	private String[] cpuAnswersOne = 
		{"Blue", "Red", "Yellow", "Green", "Orange", "Purple",};
	
	private String[] cpuAnswersTwo = 
		{"Lion", "Tiger", "Ostrich", "Zebra", "Hamster", "Parrot", "Cat", "Dog",};
	
	private String[] cpuAnswersThree = 
		{"2", "3", "5", "7", "4", "6", "8", "9"};
	
	private String[] cpuAnswersFour = 
		{"Pizza", "Chips", "Hamburgers", "Salad", "Meat", "Rice"};
	
	private String[] cpuAnswersFive = 
		{"Soccer", "Football", "Basketball", "Hockey", "Swimming", "Track"};
	
	
	public void talk() {
		/*inHelloLoop = true;
		while(inHelloLoop){
			helloCount++;
			//printResponse();
			helloResponse = DanielMain.promptInput();
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				DanielMain.promptForever();
				
			}
		} */
		
	}

	//private void printResponse() {
	//	if(helloCount > 4){
	//		int responseSelection = (int)(Math.random()*angryResponses.length);
	//		DanielMain.print(angryResponses[responseSelection]);
	//	}
	//	else{
	//		int responseSelection = (int)(Math.random()*calmResponses.length);
	//		DanielMain.print(calmResponses[responseSelection]);
	//	}
		
	//}

	public String forceResponse(String[] acceptedResponse){
		String input = getInput();
		while(notAMatch(input, acceptedResponse)){
			
		}
		return input;
	}
	
	private String getInput() {
		
		return null;
	}



	private boolean notAMatch(String input, String[] acceptedResponse) {
		for(int i = 0; i < ; i ++){
			return true;
		}
		return false;
	}
	
	public boolean isTriggered(String userInput) {
		if(DanielMain.findKeyword(userInput, "", 0) >= 0){
			return true;
		}
		return false;
		
		
	}

}