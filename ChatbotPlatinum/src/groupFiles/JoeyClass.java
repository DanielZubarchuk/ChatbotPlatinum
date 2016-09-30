package groupFiles;

public class JoeyClass implements Chatbot{
	private int pansyCounter;
	private String[] insult = {"Are you really passing again?", "Go big or go home loser",
			"Small guys wouldn't go hard like me"};
	
	
	
	public void talk() {
		
	}

	public boolean isTriggered(String s) {
		if(DanielMain.findKeyword(s, "stay", 0)>=0){
			return true;
		}
		if(DanielMain.findKeyword(s, "pass", 0)>=0){
			return true;
		}
		return false;
	}

}
