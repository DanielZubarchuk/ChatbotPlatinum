package groupFiles;

import java.util.Scanner;

public class JoeyClass implements Chatbot{
    blackJackPlayer dealer = new blackJackPlayer("Dealer", 999999999);
    blackJackPlayer player = new blackJackPlayer(DanielMain.user, 1000);

    private int annoyedCounter;
    
    
    private String[] annoyed = {"Can you please do an action that actually exists?", "How many times do I have to tell you to"
            + " do an action that actually exists?", "You aren't very good at following instructions."};
    private String[] praiseBet = {"That's a big bet.", "How much money do you have?", "*Whistles* Ey boss."};
    private String[] praiseMove = {"Wow that's a brave move.", "Big baller shot caller huh?", "Feeling lucky today?"};
    private String[] card = {"Ace", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private int[] values = {1,2,3,4,5,6,7,8,9,10,10,10,10};
    private String[] bust = {"Feelsbadsmans", "That's a bust", "Bad move"};
    
    static Scanner input = new Scanner(System.in);
    private int playerBet;
    //to create blackjack; ai deals after player places a bet. deals 2 cards per player and player makes moves until bust or stand
    //then dealer goes until and if he has 17 or more he instantly stands if he doesn't he hits again
    
    
    public static void print(String s){
        System.out.println(s);
    }
    
    public void talk() {
        
    }

    public boolean isHit(String s){
        if(DanielMain.findKeyword(s, "hit", 0)>=0){
            return true;
        }
        return false;
    }
    public boolean isStand(String s) {
        if(DanielMain.findKeyword(s, "stand", 0)>=0){
            return true;
        }
        return false;
    }
    

    private void standResponse() {
        print("Okay, the value of your hand is "+ player.getHandValue());
    }
    
    private void dumbResponse() {
        //replies annoyingly if 3+ mistakes were made
        if(annoyedCounter>3){
            int responseSelection = (int)(Math.random()*annoyed.length);
            print(annoyed[responseSelection]);
        }else {
            print("I said, please choose to stand or hit.");
        }
    }
    
    private void praiseMove(){
        //praises a hit if hand was already 15+
            int responseSelection = (int)(Math.random()*praiseMove.length);
            print(praiseMove[responseSelection]);
    }
    
    
    
    private boolean isInteger(String s) {
      boolean isValidInteger = false;
//      try
//      {   
//        Integer.parseInt(s);
//       isValidInteger = true;
//      }
//      finally{
      return isValidInteger;
   }
    
    private void buyIn(){
        boolean loop = true;
        while(loop){
            print("Welcome "+DanielMain.user+", enter a number of dollars you wish to bet.");
            if(isInteger(input.nextLine())){
                loop = false;
                playerBet = input.nextInt();
            }else{
                print("Please state a bet that is not larger than your wealth, and is in the range of $25 to $500");
                annoyedCounter++;
            }
        }
        if(playerBet<25){
            if(annoyedCounter>3){
                print(annoyed[(int)(Math.random()*praiseBet.length)]);
            }else{
                print("That bet is too low, the minimum bet is $25, and the maximum bet is $500");
                annoyedCounter++;
            }
        }
        if(playerBet>500){
            print("That bet is too high, please place a bet lower than $500.");
            annoyedCounter++;
        }
        if(playerBet>=25 && playerBet<=500){
            if(playerBet>250){
                int responseSelection = (int)(Math.random()*praiseBet.length);
                print(praiseBet[responseSelection]);
                print("Your current bet is "+playerBet);
            }else{
                print("Your current bet is "+playerBet);
            }
        }
        
        
    }
   
   private void results(){
       if(player.isBust()){
           if(dealer.isBust()){
               print("This round is a draw.");
           }else{
               print("You lose.");
               player.wealth -= playerBet;
           }
       }else{
           if(dealer.isBust()){
               print("You win!");
               player.wealth += playerBet;
           }else{
               if(player.handValue < dealer.handValue){
                   print("You lose.");
                   player.wealth -= playerBet;
               }
               if(player.handValue == dealer.handValue){
                   print("This round is a draw.");
               }
               if(player.handValue > dealer.handValue){
                   print("You win!");
                   player.wealth += playerBet;
               }
           }
       }
   }
   
   public void run(){
       while (player.wealth > 0){
           buyIn();
           dealer.hit();
           dealer.hit();
           player.hit();
           player.hit();
           while (!player.isBust() || !player.stand){
           // ask them what they wanna do next : hit, stand
           //if hit -> player.hit()
           //if player.isBust()  -> results()
           }
           while (dealer.handValue<17){
               dealer.hit();
           }
       }
            
      //you have run out of money
      }
           
   
   
public boolean isTriggered(String userInput) {
    // TODO Auto-generated method stub
    return false;
}
    
}