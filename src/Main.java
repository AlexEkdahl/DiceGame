import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("What's your name: ");
        String username = input.nextLine();
        System.out.println("Number of dices: ");
        int numberOfDices = readInt();

        Player[] players = new Player[3];
        players[0] = new Player(username, numberOfDices, 6);
        players[1] = new Player("AlexTheChamp", numberOfDices, 6);
        players[2] = new Player("LindaTheMightBeChamp", numberOfDices, 6);

        // Creates the game
        Logic game = new Logic(players);

        while (!game.checkIsWinner()) {
            System.out.println();
            game.doRound();
            System.out.println();
        }
        
        game.printWinner();

    }

    public static Scanner input = new Scanner(System.in);

    public static int readInt() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                input.next();
                System.out.println("Wopps, numbers pls, try again: ");
            }
        }
    }
}
