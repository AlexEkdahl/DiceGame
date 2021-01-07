
/* Creates a dice cup with numberOfDices dices
 Stores and saves the total sum of every throw with dice cup*/

public class DiceCup {

   private Dice diceCup[];
   private int sum;


   public DiceCup(int numberOfDices, int numberOfSides) {
      this.diceCup = new Dice[numberOfDices];
      for (int i = 0; i < diceCup.length; i++) {
         this.diceCup[i] = new Dice(numberOfSides);
      }
   }

   // Roll the dices and saves the total sum
   public void rollDices() {
      int tempSum = 0;
      for (int i = 0; i < diceCup.length; i++) {
         tempSum += diceCup[i].rollDice();
      }
      this.sum = tempSum;
   }

   public int getSum() {
      return sum;
   }

   public int length() {
      return diceCup.length;
   }

}
