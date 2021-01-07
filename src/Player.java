
/* Creates a player with a name and a dice cup
Stores total points for player */

public class Player {

   private String name;
   private DiceCup diceCup;
   private int sum;
   private boolean isWinner = false;

   public Player(String name, int numberOfDices, int numberOfSides) {
      this.name = name;
      this.diceCup = new DiceCup(numberOfDices, numberOfSides);
   }

   public void setWinner(boolean isWinner){
      this.isWinner = isWinner;
   }

   public boolean checkIfWinner(){
      return isWinner;
   }

   public int getSum() {
      return sum;
   }

   public String getName() {
      return name;
   }

   public void rollDice() {
      this.diceCup.rollDices();
      this.sum += this.diceCup.getSum();
   }

   //For debugging 
   public String toString() {
      return "Name: " + this.name + "\n" 
      + "Number of dices: " + this.diceCup.length() + "\n" 
      + "Total points: " + this.sum;
   }

}
