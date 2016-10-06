package groupFiles;

public class DanielClass implements Chatbot{

	private String helloResponse;
	private boolean inHelloLoop;
	
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
			String guess = "";
			String answer = computerChoose(questionSelection);
			boolean correct = false;
			while(!correct){
				askTheQuestion(cpuQuestions[questionSelection]);
				guess = forceResponse(getAllowedResponses(questionSelection));
				if(guess.equals(answer)){
					DanielMain.print("You guessed correctly!");
					correct = true;
				}
			}
			//DanielMain.print("You typed "+);
		} 
		
	}

	private String[] getAllowedResponses(int questionSelection) {
		if(questionSelection == 0){
			return cpuAnswersOne;
			
		}
		if(questionSelection == 1){
			return cpuAnswersTwo;
			
		}
		if(questionSelection == 2){
			return cpuAnswersThree;
			
		}
		if(questionSelection == 3){
			return cpuAnswersFour;
			
		}
		if(questionSelection == 4){
			return cpuAnswersFive;
			
		}
		return null;
	}

	private void askTheQuestion(String string) {
		DanielMain.print(string);
	}

	private String computerChoose(int questionSelection) {
		//helper method
		
		int answerSelectionOne = (int)(Math.random()*cpuAnswersOne.length);
		int answerSelectionTwo = (int)(Math.random()*cpuAnswersTwo.length);
		int answerSelectionThree = (int)(Math.random()*cpuAnswersThree.length);
		int answerSelectionFour = (int)(Math.random()*cpuAnswersFour.length);
		int answerSelectionFive = (int)(Math.random()*cpuAnswersFive.length);
		
		if(questionSelection == 0){
			return  cpuAnswersOne[answerSelectionOne];
		}
		if(questionSelection == 1){
			return cpuAnswersTwo[answerSelectionTwo];
		}
		if(questionSelection == 2){
			return cpuAnswersThree[answerSelectionThree];
		}
		if(questionSelection == 3){
			return cpuAnswersFour[answerSelectionFour];
		}
		if(questionSelection == 4){
			return cpuAnswersFour[answerSelectionFive];
		}
		return null;
	}

	public String forceResponse(String[] acceptedResponse){
		String input = DanielMain.promptInput();

		while(notAMatch(input, acceptedResponse)){
			DanielMain.print("I don't recognize that answer.");
			input = DanielMain.promptInput();
		}
		return input;
	}

	private boolean notAMatch(String input, String[] acceptedResponse) {
		
		for(int i = 0; i < acceptedResponse.length; i ++){
			if((DanielMain.findKeyword(input, acceptedResponse[i], 0) >= 0) ){
				return false;
			}
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