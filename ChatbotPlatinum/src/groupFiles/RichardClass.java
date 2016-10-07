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
	private String[] wordsHurt = {"GAME OVER    YOU LOSE", "You suck at this", "What a n00b, learn to think", "Uninstall please","LOSER, KEEP THAT 'L'"};
	private String[] encouragement = {"Are you even trying?? *Try again", "Oops, I cheated! *Try again", "Just type 'QUIT' already, we all know you're a failure. *Try again",
			"What's that in your head? Oh, nevermind its just an empty shell. *Try again", "Are you done or are you dead? *Try again", "Take the 'L' man, stop wasting everyone's time. *Try again", 
			"Do you ever get the feeling that you're being watched? Because if it is bothering you, I\'ll stop. *Try again", "Are you sure you're not the mafia? *Try again", "Stop potatoing. That is why I don't wanna be human. *Try again"};
	private String[] triggered = {"Bruh, if a trash typer like you would get a coding job, I would just fire you", "How do you fail to copy something? Do you have hand tremors or something?", "Spare us the typing and just turn off your computer. Your capable of doing that... I think",
			"Ring Ring, oh it's a message for you: LEARN TO TYPE CORRECTLY", "It must be hard pressing buttons, why don't you just unplug your keyboard.", "Take a hike so I do not have to look at your trashy typing skills."};
	static boolean inKillLoop;
	static boolean checking;
	static boolean check;
	static boolean win;
	private int killCount;
	private int totalHeadCount;
	private int happyTriggering;
	int maf1 = 1;
	int maf2 = 1;
	static String response;
	public String[] people;
	public String[] mafia;
	private String beep; 
	//public String[] copyPlayers;
	
	private void generateLiving(){
		happyTriggering = 0;
		totalHeadCount = 12;
	//	System.out.println("1");
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
	//	System.out.println("2");
		inKillLoop = true;
		checking = true;
		while(inKillLoop == true){
			DanielMain.print("Who do you want to kill?");
			response = DanielMain.promptInput();
			
			while(checking == true){
				if(checkResponse(response) == true){
					happyTriggering = 0;
//					System.out.println("4");
					replace(people, response, "");
//					System.out.println("a");
					killCount++;
//					System.out.println("b");
					userKill(response);
//					System.out.println("c");
					if(killCount == 6){
						if(checkVictory() == true){
//						System.out.println("d");
						win = true;
						break;
						}
						break;
					}
//					System.out.println("e");
					mafiaKill();
//					System.out.println("f");
					int e = (int) ((double)Math.random()*encouragement.length);
					DanielMain.print(encouragement[e]);
//					System.out.println("g");
					System.out.println(Arrays.toString(people));
					checking = false;
				}
//				if(checkResponse(response) == false){
//					System.out.println("3");
				else{
					DanielMain.print("Are you stupid? Does that look like a listed name?");
					happyTriggering++;
					if(happyTriggering > 3){
						int responseSelection = (int) (Math.random()*triggered.length);
						DanielMain.print(triggered[responseSelection]);
					}
					System.out.println(Arrays.toString(people));
					checking = false;
				}
			}
			if(killCount == 6){
//				System.out.println("5");
				inKillLoop = false;
				loser();	
			}
			if(win == true){
				inKillLoop = false;
				win();
			}
			checking = true;
		}
	}
	private boolean checkVictory(){
	//	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		int x = 0;
		for(int i = 0; i <= people.length -1; i++){
			if(people[i] == mafia[0] || people[i] == mafia[1]){
				x++;
	//			System.out.println(x);
			}
		}
		for(int i = 0; i <= people.length -1; i++){
			if(!(people[i] == mafia[0])){
				maf1--;
			}
			if(!(people[i] == mafia[1])){
				maf2--;
			}
		}
		if(x == 0 && (maf1 == 0 && maf2 == 0)){
			return true;
		}
		else{
			return false;
		}
	}
	private void loser(){
//		System.out.println("7");
		int l = (int) ((Math.random()*(wordsHurt.length-1))+1);
		DanielMain.print(wordsHurt[0]);
		DanielMain.print("The mafias were: " + Arrays.toString(mafia));
		DanielMain.print(wordsHurt[l]);
	}
	private void win(){
	//	System.out.println("8");
		DanielMain.print("Cheater, I hope you die");
	}
	private void userKill(String response){
	//	System.out.println("999");
	//	System.out.println(response);
	//	System.out.println(findResponse(response));
		replace(people, people[findResponse(response)], "");
	//	System.out.println(people[findResponse(response)]);
	}
	public int findResponse(String response){
	//	System.out.println("#*(%%@(%$");
		int count;
		count = 0;
	
		while(response.toLowerCase().equals((people[count]).toLowerCase()) == false){
			count++;
			//System.out.println("COUNT "+count);
			//System.out.println(people[count]);
		}
		return count;
//		for(int i = 0; i <= totalHeadCount - 1; i++){
//			count++;
//			System.out.println("COUNT: " + count);
//			if(response.toLowerCase().equals(people[i])){
//				 position = new  (count);
//			}
//		}
	}
	private void mafiaKill(){
	//	System.out.println("9");
		int deathByMaf = (int) (Math.random()*people.length);
		if((people[deathByMaf] == mafia[0] || people[deathByMaf] == mafia[1]) || people[deathByMaf] == ""){
	//		System.out.println("10");
			mafiaKill();
		}
		else{
	//		System.out.println("11");
			//System.out.println(people[deathByMaf]);
			replace(people, people[deathByMaf], "");
		}
	}
	private boolean checkResponse(String response){
	//	System.out.println("12");
		check = true;
		boolean inList = false;
		int count = 0;
		while(check == true){
			
	//		System.out.println("13");
			//System.out.println(response);
			//System.out.println(people[count]);
			if(response.toLowerCase().equals(people[count].toLowerCase())){
	//			System.out.println("14");
				inList = true;
				check = false;
			}
			
			count++;
	//		System.out.println("COUNT: " +count);
			if(count == totalHeadCount){
				check = false;
			}
			
		}
//		for(int i = 0; i <= totalHeadCount-1; i++){
//			
//		}	
		//System.out.println("gottem");
	//	System.out.println("gbasfkghalskglasjgo;asj" +inList);
		return inList;
	}

	public String[] pickVictums(){	
	//	System.out.println("15");
		String[]victumList;
		victumList = new String[totalHeadCount];
		//make copy of 'names'
		String[] dummyNames = new String[names.length];
		System.arraycopy(names, 0, dummyNames, 0, names.length);
		//System.out.println(Arrays.toString(dummyNames));
		for(int i=0; i<=11; i++){
	//		System.out.println("16");
			int victum = (int) ((double) Math.random()*(dummyNames.length - 1))+1;
			//System.out.println("THIS ONE IS PICKED " + dummyNames[victum]);
				if(dummyNames[victum] == ""){
	//				System.out.println("17");
					i--;
				}
				else{
	//				System.out.println("18");
				replace(victumList, victumList[i], dummyNames[victum]);
				replace(dummyNames, dummyNames[victum], "");
				//System.out.println("THIS ONE:" + victum);
				//System.out.println(Arrays.toString(dummyNames));
				}
		}
	//	System.out.println("19");
		//System.out.println("***************** " + Arrays.toString(victumList));
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
	//	System.out.println("20");
		String[]mafia;
		mafia = new String[2];
			for(int i = 0; i <= 1; i++){
				for(int j = 0; j<= (totalHeadCount/2)-1; j++){
					if(i==j){
						//System.out.println(list[(i*5)+j]);
						//System.out.println(Arrays.toString(mafia));
						replace(mafia, null, list[(i*5)+j]);
						}
					if(mafia[0] == mafia[1]){
							i--;
					}
				}
			}
//			System.out.println("##################### " + Arrays.toString(mafia));
			return mafia;
	}
	public String[] randomize(String[]players){
	//	System.out.println("21");
		String[]randomized;
		randomized = new String[totalHeadCount];
		System.arraycopy(players, 0, randomized, 0, totalHeadCount);
		int x = (int) (Math.random()*totalHeadCount);
		int y = (int) (Math.random()*totalHeadCount);
		//System.out.println("THIS IS X: " + x);
		//System.out.println("THIS IS Y: " + y);
		String copyX = players[x];
		//System.out.println(copyX);
		String copyY = players[y];
		//System.out.println(copyY);
		//mafia index is 0 and 5
		//System.out.println("ORIGINAL: " + Arrays.toString(randomized));
		replace(randomized, players[x], players[0]);
		//System.out.println("FRIST: " + Arrays.toString(randomized));
		replace(randomized, players[0], copyX);
		//System.out.println("SECOND: " + Arrays.toString(randomized));
		replace(randomized, players[y], players[5]);
		//System.out.println("THRID: " + Arrays.toString(randomized));
		replace(randomized, players[5], copyY);
		//System.out.println("FORTH: " + Arrays.toString(randomized));
		return randomized;
	}
		
//		String[] randomizedList;
//		randomizedList = new String[list.length]; 
//		for(int i = 0; i<list.length; i++){
//			replace(randomizedList, "", String[][])
//		}
	@Override
	public void talk() {
	//	System.out.println("22");
		inRichardClassLoop = true;
		//static call on promptInput method from DanielMain class
		while(inRichardClassLoop){
			generateLiving();
			DanielMain.print("(Type 'quit' to go back)");
			beep = DanielMain.promptInput();
			if(beep.indexOf("quit") >= 0){
				inRichardClassLoop = false;
				DanielMain.promptGame();
			}
			if(!isTriggered(beep)){
				inRichardClassLoop = false;
				DanielMain.promptGame();
			}
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
//		System.out.println("23");
		if(happyTriggering >= 3){
			return true;
		}
		return false;
	}
}
