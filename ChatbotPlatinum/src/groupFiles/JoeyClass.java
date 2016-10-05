package groupFiles;

import java.util.Scanner;

import chatbot.JoeyMain;

public class JoeyClass implements Chatbot{
	private int pansyCounter;
	private int annoyedCounter;
	
	
	private String[] annoyed = {"Can you please do an action that actually exists?", "How many times do I have to tell you to"
			+ " hit or stand?", "You aren't very good at following instructions."};
	private String[] insult = {"Are you really passing again?", "Go big or go home loser",
			"Small guys wouldn't go hard like me"};
	private String[] praise = {"Wow that's a brave move.", "Big baller shot caller huh?", "Feeling lucky today?"};
	private String[] suites = {"Spades","Clubs","Hearts","Diamonds"};
	private String[] values = {"Ace", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

	static Scanner input;
	//to create blackjack; ai deals after player places a bet. deals 2 cards per player and player makes moves until bust or stand
	//then dealer goes until and if he has 17 or more he instantly stands if he doesn't he hits again
	
	private int myHandValue;
	private String[] myCards;
	private int dealerHandValue;
	private String[] dealersCards;
	private int playerBet;
	private int currentWealth;
	private int minimumBet = 25;
	
	
	
	public static void print(String s){
	 	System.out.println(s);
	}
	
	public void talk() {
		
	}

	public boolean isTriggered(String s) {
		if(DanielMain.findKeyword(s, "stand", 0)>=0){
			return true;
		}
		return false;
	}
	

	private void standResponse() {
		if(pansyCounter>4){
			int responseSelection = (int)(Math.random()*insult.length);
			print(insult[responseSelection]);
		}else {
			print("Okay, the value of your hand is "+myHandValue);
		}
	}
	
	private void dumbResponse() {
		if(annoyedCounter>4){
			int responseSelection = (int)(Math.random()*annoyed.length);
			print(annoyed[responseSelection]);
		}else {
			print("I said, please choose to stand or hit.");
		}
	}
	
	private void praiseResponse() {
		if(pansyCounter>4){
			int responseSelection = (int)(Math.random()*praise.length);
			print(praise[responseSelection]);
		}else {
			print("Okay, the value of your hand is "+myHandValue);
		}
	}
	
	
	
	
	
	
	
	private int buyIn(){
		//find out how to move the name and input over
		//find out how to retrieve int from input
		print("Welcome "+user+", How much would you like to bet?");
		playerBet = input.nextLine();
	}
	
	private void hit(){
		
	}
	
	private void deal(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}