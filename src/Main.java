import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("What's your name: ");
        String username = input.nextLine();
        System.out.println("Number of dices: ");
        int numberOfDices = readInt();

        Player[] players = new Player[3];
        players[0] = new Player(username, numberOfDices, 6);
        players[1] = new Player("Alex", numberOfDices, 6);
        players[2] = new Player("Linda", numberOfDices, 6);

        // Creates the game
        Logic game = new Logic(players);

        while (!game.checkIsWinner()) {
            System.out.println();
            game.doRound();
            System.out.println();
        }

        // Check who's the winner
        Player winner = game.highestScore();
        System.out.println("The winner is: " + winner.getName() + " with score: " + winner.getSum());
        game.getScores();

    }

    public static Scanner input = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Nu blev det fel. Heltal och med siffror. Prova igen: ");
            }
        }
    }
}
