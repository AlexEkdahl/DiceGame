import java.util.*;

public class Logic {
   // just for educational purpuse
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

   public boolean checkForWinner() {
      for (Player player : players) {
         if (player.getSum() >= SCORE_TO_WIN && player.getSum() == highestScore()) {
            player.setWinner(true);
            return true;
         }
      }
      return false;
   }

   // just for trying out hashmap
   public void getScores() {
      playerScores.forEach((key, value) -> System.out.println(key + ":" + value));
   }

   // Itterate through players to get to player with isWinner set to true
   public void printWinner() {
      for (Player player : players) {
         if (player.checkIfWinner()) {
            System.out
                  .println("The winner is: " + player.getName() + " with a total of " + player.getSum() + " points!");
         }
      }
   }

   public int highestScore() {
      int bestScore = 0;
      for (int i = 0; i < players.length; i++) {
         if (players[i].getSum() > bestScore) {
            bestScore = players[i].getSum();
         }
      }
      return bestScore;
   }
}
