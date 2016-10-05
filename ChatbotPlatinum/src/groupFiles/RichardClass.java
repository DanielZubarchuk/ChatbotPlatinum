package groupFiles;

public class RichardClass implements Chatbot{
	private boolean inRichardClassLoop = true;
	//boolean with 12 elements
	//auto* all of them false
	//random make 2 true
	
	//newLiving = new String[oldLiving.length-1];
	//add names from old to new
	//oldLKiving = newLivintg;
	private String[] names = {"Joey", "Richard", "Daniel", "Victor", "Tobi", "Nockles", "Pickles", "Poon Bear", "Irene", 
			"Amy", "Oscar", "Tina", "Jonathan", "Willy", "Dubby", "Terrance", "Jae", "Shirley", "Sara", "Taylor"};
	private String[] wordsHurt = {"You suck at this", "What a n00b, learn to think", "Give up", "Uninstall please","LOSER, KEEP THAT 'L'"};
	private String[] encouragement = {"Are you even trying??", "Oops, I cheated", "Just type 'QUIT' alreay, we all know you're a failure",
			"What's that in your head? Oh, nevermind its just an empty shell", "Are you done or are you dead?", "Take the 'L' man, stop wasting everyone's time"};
	static boolean inKillLoop;
	private int killCount;
	private int totalHeadCount;
	static String response;
	public String[] people;
	public String[] mafia;
	private String beep; 
	private int happyTriggering;
	public RichardClass(){
		killCount = 0;
		totalHeadCount = 12;

		generateLiving();
		killLoop();
		}
	private void generateLiving(){
		String[] players;
		players = new String[totalHeadCount];
		System.arraycopy(pickVictums(), 0, players, 0, totalHeadCount);
		mafia = setMafia(players);
		people = randomize(players);
		System.out.println(people);
		killLoop();
	}
	public void killLoop(){
		inKillLoop = true;
		while(inKillLoop == true){
			DanielMain.print("Who do you want to kill?");
			response = DanielMain.promptInput();
			if(checkResponse(response) == false){
				DanielMain.print("Dude are you stupid? Does that look like a listed name?");
				happyTriggering++;
			}
			if(checkResponse(response) == true){
				replace(people, response, "");
				killCount++;
				mafiaKill();
				int e = (int) ((double)Math.random()*encouragement.length)-1;
				DanielMain.print(encouragement[e]);
			}
			if(people.length == 4){
				inKillLoop = false;
				loser();
				
			}
			if(mafia[0] == null && mafia[1] == null){
				inKillLoop = false;
				win();
			}
		}
	}
	private void loser(){
		int l = (int) ((double)Math.random()*wordsHurt.length)-1;
		DanielMain.print(wordsHurt[l]);
	}
	private void win(){
		DanielMain.print("Cheater, I hope you die");
	}
	private void mafiaKill(){
		int deathByMaf = (int) ((double) Math.random()*(people.length - killCount));
		if(people[deathByMaf] == mafia[0] || people[deathByMaf] == mafia[1] || people[deathByMaf] == ""){
			mafiaKill();
		}
		else{
			replace(people, people[deathByMaf], "");
		}
	}
	private boolean checkResponse(String response){
		for(int i = 0; i <= totalHeadCount-1; i++){
			if(response == people[i]){
				return true;
			}
		}	
		return false;
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
	public String[] setMafia(String[]list){
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
			return mafia;
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
		inRichardClassLoop = true;
		//static call on promptInput method from RichardMain class
		while(inRichardClassLoop){
			DanielMain.print("(Type 'quit' to go back)");
			beep = DanielMain.promptInput();
			if(beep.indexOf("quit") >= 0){
				inRichardClassLoop = false;
				DanielMain.promptForever();
			}
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(happyTriggering >= 3){
			return true;
		}
		return false;
	}
}
