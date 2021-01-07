
/*Creates a single dice with numberOfSides sides
Stores the last value of the dice*/

import java.util.Random;

public class Dice {

   private int numOfSides;
   private int lastValue;

   public Dice(int numberOfSides) {
      this.numOfSides = numberOfSides;
   }

   public int getNumOfSides() {
      return numOfSides;
   }

   public int getLastValue() {
      return lastValue;
   }

   public int rollDice() {
      Random rand = new Random();
      this.lastValue = rand.nextInt(numOfSides) + 1;
      return lastValue;

   }

}
