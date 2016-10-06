package groupFiles;

public class blackJackPlayer {
        private String name;
        public int handValue;
        private int aceCounter;
        public int wealth;
        public boolean stand = false;
        private String[] card = {"Ace", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        private int[] values = {11,2,3,4,5,6,7,8,9,10,10,10,10};

        //constructor
        public blackJackPlayer(String nameInput, int wealthInput){
            name = nameInput;
            handValue = 0;
            aceCounter = 0;
            wealth = wealthInput;
            
        }

        public String getName(){
            return name;
        }
        
        public int getHandValue(){
                return handValue;
        }


        public String hit(){
            int pick = (int)(Math.random()*card.length);
            
            if(pick == 0){
                //JoeyClass.print(name + " was dealt an "+card[pick]);
                handValue += values[pick];
                aceCounter++;
            } else{
                //JoeyClass.print("was dealt a"+card[pick]);
                handValue += values[pick];
            }
            
            if(isBust() && aceCounter>0){
                aceCounter--;
                handValue-=10;
            }
            
            return card[pick];
            
        }
        
        public boolean isBust(){
        return handValue > 21;
    
    }
}