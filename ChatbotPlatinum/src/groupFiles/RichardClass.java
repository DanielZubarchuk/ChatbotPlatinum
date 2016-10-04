package groupFiles;

public class RichardClass implements Chatbot{
	//boolean with 12 elements
	//auto* all of them false
	//random make 2 true
	
	//newLiving = new String[oldLiving.length-1];
	//add names from old to new
	//oldLKiving = newLivintg;
	private String[] names = {"Joey", "Richard", "Daniel", "Victor", "Tobi", "Nockles", "Pickles", "Poon Bear", "Irene", 
			"Amy", "Oscar", "Tina", "Jonathan", "Willy", "Dubby", "Terrance", "Jae", "Shirley", "Sara"};
	private String[] wordsHurt = {"You suck at this", "What a n00b, learn to think", "Give up", "Uninstall please"};
	private boolean inKillLoop;
	private int killCount;
	private int totalHeadCount;
	
	public RichardClass(){
		killCount = 0;
		totalHeadCount = 12;

		generateLiving();
		}
	private void generateLiving(){
		int counter = 0;
		String[] living = {};
		//make copy of 'names'
		String[] dummyNames = names;
		while(living.length < 12){
			int pickAPlayer = (int) (Math.random() * dummyNames.length);
			living = new String[living.length+1];
			living[living.length+1] = dummyNames[pickAPlayer];
			dummyNames[pickAPlayer] = "";
		}
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
