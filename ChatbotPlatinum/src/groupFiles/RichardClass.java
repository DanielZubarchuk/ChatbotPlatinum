package groupFiles;

public class RichardClass implements Chatbot{
	//boolean with 12 elements
	//auto* all of them false
	//random make 2 true
	
	//newLiving = new String[oldLiving.length-1];
	//add names from old to new
	//oldLKiving = newLivintg;
	private String[] names = {"Joey", "Richard", "Daniel", "Victor", "Tobi", "Nockles", "Pickles", "Poon Bear", "Irene", 
			"Amy", "Oscar", "Tina", "Jonathan", "Willy", "Dubby", "Terrance", "Jae", "Shirley", "Sara", "Taylor"};
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
//		Player[] living;
		String[] players;
		players = new String[totalHeadCount];
		System.arraycopy(pickVictums(), 0, players, 0, totalHeadCount);
		setMafia(players);
		System.out.println(randomize(players));
		
	}

	public String[] pickVictums(){	
		String[]victumList;
		victumList = new String[totalHeadCount];
		//make copy of 'names'
		String[] dummyNames = new String[names.length];
		System.arraycopy(names, 0, dummyNames, 0, names.length);
		for(int i=0; i<=11; i++){
			int victum = (int) ((double) Math.random()*(dummyNames.length - 1))+1;
				if(dummyNames[victum] == null){
					i--;
				}
				else{
				replace(victumList, victumList[i], dummyNames[victum]);
				replace(dummyNames, dummyNames[victum], "");
				}
		}
		return victumList;
	}
	//make replace method
	static void replace(String[] array, String find, String replace){
		for(int i = 0; i <array.length; i++){
			if(array[i] == find){
				array[i] = replace;
				return;
			}
		}
	}
	public void setMafia(String[]list){
		String[]mafia;
		mafia = new String[2];
	//	if((list.length % 2) == 0){
			for(int i = 0; i <= totalHeadCount/totalHeadCount; i++){
				for(int j = 0; j<= (totalHeadCount/2)-1; j++){
					if(i==1 && j==1){
						replace(mafia, "", list[(i*5)+j]);
					}
				}
	//	else{		
	//	}
			}
			return;
	}
	public String[] randomize(String[]players){
		String[]randomized;
		randomized = new String[totalHeadCount];
		System.arraycopy(players, 0, randomized, 0, totalHeadCount);
		int x = (int) ((double)Math.random()*totalHeadCount)+1;
		int y = (int) ((double)Math.random()*totalHeadCount)+1;
		String copyX = players[x];
		String copyY = players[y];
		//mafia index is 0 and 5
		replace(randomized, players[x], players[0]);
		replace(randomized, players[0], copyX);
		replace(randomized, players[y], players[5]);
		replace(randomized, players[5], copyY);
		return randomized;
	}
		
//		String[] randomizedList;
//		randomizedList = new String[list.length]; 
//		for(int i = 0; i<list.length; i++){
//			replace(randomizedList, "", String[][])
//		}
		
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
