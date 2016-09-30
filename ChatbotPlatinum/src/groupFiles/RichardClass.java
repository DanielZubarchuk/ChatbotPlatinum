package groupFiles;

public class RichardClass implements Chatbot{
	private String[] wordsHurt = {"You suck at this", "What a n00b, learn to think", "Give up", "Uninstall please"};
	@Override
	public void talk() {
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(DanielMain.findKeyword(userInput, "kill", 0) >= 0){
			return true;
		}
		return false;
	}

}
