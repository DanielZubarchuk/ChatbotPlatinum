package groupFiles;

public class DanielClass implements Chatbot{

	private boolean inHelloLoop;
	
	private String[] cpuQuestions = 
		{"What Color Am I Thinking Of?", "What Animal Am I Thinking Of?", "What Number Am I Thinking Of?(Between 1 and 10)", "What is my favorite food?", "What is my favorite Sport?"};
	
	private String[] cpuAnswersOne = 
		{"Blue", "Red", "Yellow", "Green", "Orange", "Purple"};
	// first 3 colors are primary colors, meanwhile second 3 are secondary
	
	private String[] cpuAnswersTwo = 
		{"Lion", "Tiger", "Ostrich", "Zebra", "Hamster", "Parrot", "Cat", "Dog"};
	// first 4 animals are wild animals, meanwhile the rest are domestic
	
	private String[] cpuAnswersThree = 
		{"2", "3", "5", "7", "4", "6", "8", "9"};
	// first 4 numbers are prime, others are composite.
	
	private String[] cpuAnswersFour = 
		{"Pizza", "Chips", "Hamburgers", "Salad", "Meat", "Rice"};
	// first 3 foods are unhealthy, meanwhile second 3 foods are healthy
	
	private String[] cpuAnswersFive = 
		{"Soccer", "Football", "Basketball", "Hockey", "Swimming", "Track"};
	// first 3 sports include a ball, other 3 do not
	
	
	public void talk() {
		inHelloLoop = true;
		int questionSelection = (int)(Math.random()*cpuQuestions.length);
		String answer = computerChoose(questionSelection);
		askTheQuestion(cpuQuestions[questionSelection]);
		while(inHelloLoop){
			String guess = "";
			boolean correct = false;
			while(!correct){
				//getSpecificHint();
				guess = forceResponse(getAllowedResponses(questionSelection));
				if(guess.equals(answer)){
					DanielMain.print("You guessed correctly!");
					correct = true;
					talk();
				}
				else{
					getSpecificHint(answer, questionSelection);
				}

			}
			//DanielMain.print("You typed "+);
		} 
		
	}

	private String getSpecificHint(String real, int question){
		if(question == 0){
			if (real.equals("Blue") || real.equals("Yellow") || real.equals("Red")){
				DanielMain.print("It is a primary color");
			}
			else
			{
				DanielMain.print("It is a secondary color!");
			}			
		}
		if(question == 1)
		{
			if (real.equals("Lion") || real.equals("Tiger") || real.equals("Ostrich") || real.equals("Zebra")){
				DanielMain.print("It is a wild animal.");
			}
			else
			{
				DanielMain.print("It is a domestic animal");
			}	
			
		}
		if(question == 2){
			if (real.equals("2") || real.equals("3") || real.equals("5") || real.equals("7")){
				DanielMain.print("It is a prime number.");
			}
			else
			{
				DanielMain.print("It is not a prime number");
			}	
			
		}
		if(question == 3){
			if (real.equals("Pizza") || real.equals("Hamburgers") || real.equals("Chips")){
				DanielMain.print("It is an unhealthy food.");
			}
			else
			{
				DanielMain.print("It is a healthy food.");
			}	
			
		}
		if(question == 4){
			if (real.equals("Soccer") || real.equals("Football") || real.equals("Basketball"))
			{
				DanielMain.print("It is a sport that needs a ball.");
			}
			else
			{
				DanielMain.print("This sport doesn’t need a ball.");
			}	
			
		}

		return null;
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