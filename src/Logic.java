import java.util.*;

public class Logic {

   private HashMap<String, Integer> playerScores = new HashMap<>();
   private Player players[];
   final int SCORE_TO_WIN = 150;

   public Logic(Player players[]) {
      this.players = players;

      // Save players name and gives them the starting point of 0
      for (Player player : this.players) {
         playerScores.put(player.getName(), 0);
      }
   }

   // Roll all players dice cup and
   // replace players score with new score in hashmap
   public void doRound() {
      for (Player player : players) {
         player.rollDice();
         System.out.println(player.getName() + ": " + player.getSum());

         playerScores.replace(player.getName(), player.getSum());

      }
   }

   public boolean checkIsWinner() {
      for (Player player : players) {
         if (player.getSum() >= SCORE_TO_WIN && isSameScore()) {
            player.setWinner(true);
            return true;
         }
      }
      return false;
   }

   // Sorts temp list with ascending order
   // If two players with highest score is the same then there are no winner
   public boolean isSameScore() {
      ArrayList<Integer> tempScores = new ArrayList<>();
      for (Player player : players) {
         tempScores.add(player.getSum());
      }
      Collections.sort(tempScores);

      if (tempScores.get(tempScores.size() - 1) != (tempScores.get(tempScores.size() - 2))) {
         return true;
      }
      return false;
   }

   public void getScores() {
      playerScores.forEach((key, value) -> System.out.println(key + ":" + value));
   }

   // Itterate through players to get to player with isWinner set to true
   public void printWinner() {
      for(Player player: players){
         if (player.checkIfWinner()){
            System.out.println("The winner is: " + player.getName() 
            + " with a total of " + player.getSum() + " points!" );
         }
      }
   }
}
