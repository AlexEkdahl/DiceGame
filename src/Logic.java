import java.util.*;

public class Logic {

   private HashMap<String, Integer> scores = new HashMap<>();
   private Player players[];
   final int SCORE_TO_WIN = 1000;


   public Logic(Player players[]) {
      this.players = players;

      // Save players name and gives them the starting point of 0
      for (Player player : this.players) {
         scores.put(player.getName(), 0);
      }
   }

   // Roll all players dice cup and
   // replace players score with new score in hashmap
   public void doRound() {
      for (Player player : players) {
         player.rollDice();
         System.out.println(player.getName() + ": " + player.getSum());

         scores.replace(player.getName(), player.getSum());

      }
   }

   public boolean checkIsWinner() {
      for (Player player : players) {
         if (player.getSum() >= SCORE_TO_WIN && !isSameScore()) {
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

      if (tempScores.get(0) == (tempScores.get(1))) {

         return true;
      } else {
         return false;
      }
   }

   public void getScores() {
      scores.forEach((key, value) -> System.out.println(key + ":" + value));
   }

   // Itterate through players to get the one with the highest score
   public Player highestScore() {
      int bestScore = 0;
      int bestIndex = 0;
      for (int i = 0; i < players.length; i++) {
         if (players[i].getSum() > bestScore) {
            bestScore = players[i].getSum();
            bestIndex = i;
         }
      }
      return players[bestIndex];
   }

}
