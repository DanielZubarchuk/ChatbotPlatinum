package groupFiles;

import groupFiles.JoeyClass;

public class blackJackPlayer {
	public String name;
	public int handValue;
	public int aceCounter;
	public int wealth;
	public boolean stand = false;
	private String[] card = {"Ace", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	private int[] values = {11,2,3,4,5,6,7,8,9,10,10,10,10};

	//constructor
	public blackJackPlayer(String nameInput, int wealthInput){
		handValue = 0;
		aceCounter = 0;
		wealth = wealthInput;
		name = nameInput;
	}


	public void changeName(String newName){
		name = newName;
	}


	public String hit(){
		int pick = (int)(Math.random()*card.length);
		if(pick == 0){
			JoeyClass.print(name + " was dealt an "+card[pick]);
			aceCounter++;
			handValue += values[pick];
			if(isBust() && aceCounter>0){
				aceCounter--;
				handValue-=10;
			}
			JoeyClass.print(name + "'s hand value is now "+ handValue);
		} else{
			JoeyClass.print(name +" was dealt a "+card[pick]);
			handValue += values[pick];

			if(isBust() && aceCounter>0){
				aceCounter--;
				handValue-=10;
			}
			JoeyClass.print(name + "'s hand value is now "+ handValue);
		}

		return card[pick];

	}

	public boolean blackjackTest(){
		if(handValue == 21){
			return true;
		}else
			return false;
	}


	public boolean isBust(){
		return handValue > 21;

	}
}