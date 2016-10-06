package groupFiles;

import java.util.Arrays;

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
	private String[] encouragement = {"Are you even trying?? Try again", "Oops, I cheated! *Try again?", "Just type 'QUIT' alreay, we all know you're a failure. *Try again?",
			"What's that in your head? Oh, nevermind its just an empty shell. *Try again?", "Are you done or are you dead? *Try again?", "Take the 'L' man, stop wasting everyone's time. *Try again?"};
	static boolean inKillLoop;
	private int killCount;
	private int totalHeadCount;
	static String response;
	public String[] people;
	public String[] mafia;
	private String beep; 
	private int happyTriggering;
	//public String[] copyPlayers;
	
	private void generateLiving(){
		totalHeadCount = 12;
		System.out.println("1");
		String[] players;
		players = new String[totalHeadCount];
		
	//	copyPlayers = new String[totalHeadCount];
		System.arraycopy(pickVictums(), 0, players, 0, totalHeadCount);
		mafia = setMafia(players);
		people = randomize(players);
	//	System.arraycopy(players, 0, copyPlayers, 0, totalHeadCount);
		System.out.println(Arrays.toString(people));
		killLoop();
	}
	public void killLoop(){
		killCount = 0; 
		System.out.println("2");
		inKillLoop = true;
		while(inKillLoop == true){
			DanielMain.print("Who do you want to kill?");
			response = DanielMain.promptInput();
			if(checkResponse(response) == false){
				System.out.println("3");
				DanielMain.print("Dude are you stupid? Does that look like a listed name?");
				happyTriggering++;
			}
			if(checkResponse(response) == true){
				System.out.println("4");
				replace(people, response, "");
				killCount++;
				mafiaKill();
				userKill();
				int e = (int) ((double)Math.random()*encouragement.length)-1;
				DanielMain.print(encouragement[e]);
				System.out.println(Arrays.toString(people));
			}
			if(people.length == 4){
				System.out.println("5");
				inKillLoop = false;
				loser();
				
			}
			if(mafia[0] == null && mafia[1] == null){
				System.out.println("6");
				inKillLoop = false;
				win();
			}
		}
	}
	private void loser(){
		System.out.println("7");
		int l = (int) ((double)Math.random()*wordsHurt.length)-1;
		DanielMain.print(wordsHurt[l]);
	}
	private void win(){
		System.out.println("8");
		DanielMain.print("Cheater, I hope you die");
	}
	private void userKill(){
		
	}
	private void mafiaKill(){
		System.out.println("9");
		int deathByMaf = (int) ((double) Math.random()*(people.length - killCount));
		if(people[deathByMaf] == mafia[0] || people[deathByMaf] == mafia[1] || people[deathByMaf] == ""){
			System.out.println("10");
			mafiaKill();
		}
		else{
			System.out.println("11");
			replace(people, people[deathByMaf], "");
		}
	}
	private boolean checkResponse(String response){
		System.out.println("12");
		boolean checking = true;
		boolean inList = false;
		int count = 0;
		while(checking == true){
			
			System.out.println("13");
			System.out.println(response);
			System.out.println(people[count]);
			if(response.toLowerCase().equals(people[count].toLowerCase())){
				System.out.println("14");
				inList = true;
				checking = false;
			}
			count++;
			if(count == totalHeadCount -1){
				checking = false;
			}
		}
//		for(int i = 0; i <= totalHeadCount-1; i++){
//			
//		}	
		System.out.println("gottem");
		System.out.println(inList);
		return inList;
	}

	public String[] pickVictums(){	
		System.out.println("15");
		String[]victumList;
		victumList = new String[totalHeadCount];
		//make copy of 'names'
		String[] dummyNames = new String[names.length];
		System.arraycopy(names, 0, dummyNames, 0, names.length);
		System.out.println(Arrays.toString(dummyNames));
		for(int i=0; i<=11; i++){
			System.out.println("16");
			int victum = (int) ((double) Math.random()*(dummyNames.length - 1))+1;
			System.out.println("THIS ONE IS PICKED " + dummyNames[victum]);
				if(dummyNames[victum] == ""){
					System.out.println("17");
					i--;
				}
				else{
					System.out.println("18");
				replace(victumList, victumList[i], dummyNames[victum]);
				replace(dummyNames, dummyNames[victum], "");
				System.out.println("THIS ONE:" + victum);
				System.out.println(Arrays.toString(dummyNames));
				}
		}
		System.out.println("19");
		System.out.println("***************** " + Arrays.toString(victumList));
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
		System.out.println("20");
		String[]mafia;
		mafia = new String[2];
	//	if((list.length % 2) == 0){
			for(int i = 0; i <= 1; i++){
				for(int j = 0; j<= (totalHeadCount/2)-1; j++){
					if(i==j){
						System.out.println(list[(i*5)+j]);
						System.out.println(Arrays.toString(mafia));
						replace(mafia, null, list[(i*5)+j]);
						}
					if(mafia[0] == mafia[1]){
							i--;
					}
				}
	//	else{		
	//	}
			}
			System.out.println("##################### " + Arrays.toString(mafia));
			return mafia;
	}
	public String[] randomize(String[]players){
		System.out.println("21");
		String[]randomized;
		randomized = new String[totalHeadCount];
		System.arraycopy(players, 0, randomized, 0, totalHeadCount);
		int x = (int) (Math.random()*totalHeadCount);
		int y = (int) (Math.random()*totalHeadCount);
		System.out.println("THIS IS X: " + x);
		System.out.println("THIS IS Y: " + y);
		String copyX = players[x];
		System.out.println(copyX);
		String copyY = players[y];
		System.out.println(copyY);
		//mafia index is 0 and 5
		System.out.println("ORIGINAL: " + Arrays.toString(randomized));
		replace(randomized, players[x], players[0]);
		System.out.println("FRIST: " + Arrays.toString(randomized));
		replace(randomized, players[0], copyX);
		System.out.println("SECOND: " + Arrays.toString(randomized));
		replace(randomized, players[y], players[5]);
		System.out.println("THRID: " + Arrays.toString(randomized));
		replace(randomized, players[5], copyY);
		System.out.println("FORTH: " + Arrays.toString(randomized));
		return randomized;
	}
		
//		String[] randomizedList;
//		randomizedList = new String[list.length]; 
//		for(int i = 0; i<list.length; i++){
//			replace(randomizedList, "", String[][])
//		}
		
	@Override
	public void talk() {
		System.out.println("22");
		inRichardClassLoop = true;
		//static call on promptInput method from DanielMain class
		while(inRichardClassLoop){
			generateLiving();
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
		System.out.println("23");
		if(happyTriggering >= 3){
			return true;
		}
		return false;
	}
}
