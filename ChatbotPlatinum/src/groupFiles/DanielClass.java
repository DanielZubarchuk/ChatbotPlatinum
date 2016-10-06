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
		{"Blue", "Red", "Yellow", "Green", "Orange", "Purple"};
	
	private String[] cpuAnswersTwo = 
		{"Lion", "Tiger", "Ostrich", "Zebra", "Hamster", "Parrot", "Cat", "Dog"};
	
	private String[] cpuAnswersThree = 
		{"2", "3", "5", "7", "4", "6", "8", "9"};
	
	private String[] cpuAnswersFour = 
		{"Pizza", "Chips", "Hamburgers", "Salad", "Meat", "Rice"};
	
	private String[] cpuAnswersFive = 
		{"Soccer", "Football", "Basketball", "Hockey", "Swimming", "Track"};
	
	
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			int questionSelection = (int)(Math.random()*cpuQuestions.length);
			int answerSelectionOne = (int)(Math.random()*cpuAnswersOne.length);
			int answerSelectionTwo = (int)(Math.random()*cpuAnswersTwo.length);
			int answerSelectionThree = (int)(Math.random()*cpuAnswersThree.length);
			int answerSelectionFour = (int)(Math.random()*cpuAnswersFour.length);
			int answerSelectionFive = (int)(Math.random()*cpuAnswersFive.length);
			
			DanielMain.print(cpuQuestions[questionSelection]);
			//guess is guaranteed to contain a keyword from the arrays
			if(questionSelection == 0){
				String guessOne = forceResponse(cpuAnswersOne);
				String correctAnswer =  cpuAnswersOne[answerSelectionOne];
			}
			if(questionSelection == 1){
				String guessTwo = forceResponse(cpuAnswersTwo);
				String correctAnswer = cpuAnswersTwo[answerSelectionTwo];
			}
			if(questionSelection == 2){
				String guessThree = forceResponse(cpuAnswersThree);
				String correctAnswer = cpuAnswersThree[answerSelectionThree];
			}
			if(questionSelection == 3){
				String guessFour = forceResponse(cpuAnswersFour);
				String correctAnswer = cpuAnswersFour[answerSelectionFour];
			}
			if(questionSelection == 4){
				String guessFive = forceResponse(cpuAnswersFive);
				String correctAnswer = cpuAnswersFour[answerSelectionFive];
			}
			DanielMain.print("You typed "+ helloResponse);
		} 
		
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
		String input = DanielMain.promptInput();
		while(notAMatch(input, acceptedResponse)){
			DanielMain.print("I don't recognize that answer.");
			input = DanielMain.promptInput();
		}
		return input;
	}

	private boolean notAMatch(String input, String[] acceptedResponse) {
			if(DanielMain.findKeyword(input, acceptedResponse[0], 0) >= 0){
				return false;
			}
		return true;
	}
	
	public boolean isTriggered(String userInput) {
		if(DanielMain.findKeyword(userInput, "", 0) >= 0){
			return true;
		}
		return false;
		
		
	}

}