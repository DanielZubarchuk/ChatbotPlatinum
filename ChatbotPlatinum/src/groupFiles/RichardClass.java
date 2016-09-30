package groupFiles;

public class RichardClass implements Chatbot{
	//boolean with 12 elements
	//auto* all of them false
	//random make 2 true
	
	//newLiving = new String[oldLiving.length-1];
	//add names from old to new
	//oldLKiving = newLivintg;
	private String[] names = {"Joey", "Richard", "Daniel", "Victor", "Tobi", ""};
	private String[] wordsHurt = {"You suck at this", "What a n00b, learn to think", "Give up", "Uninstall please"};
	private boolean inKillLoop;
	private int killCount;
	private int totalHeadCount;
	
	public RichardClass(){
		killCount = 0;
		totalHeadCount = 12;	
		}
	
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
