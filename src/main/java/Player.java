import java.util.Scanner;

/**
 * Created by zsuleiman on 10/06/2017.
 */
public class Player {


    private static Scanner inputStream;

    public Player() {

        inputStream = new Scanner(System.in);
    }

    public static RockPaperScissors.Move getMove() {

        // Get User Move
        System.out.print("Rock! Paper! Scissors!!:\n" +
                "Please Choose Move:\n" +
                " 1 - Rock\n" +
                " 2 - Paper\n" +
                " 3 - Scissor\n");
        String userInput = inputStream.nextLine();

        switch (Integer.parseInt(userInput)) {
            case 1:
                return RockPaperScissors.Move.ROCK;
            case 2:
                return RockPaperScissors.Move.PAPER;
            case 3:
                return RockPaperScissors.Move.SCISSORS;

        }
        return null;
    }


    public boolean retryGame() {
        System.out.print("Do you want to Play again?");
        return inputStream.nextLine().toUpperCase().contains("Y");

    }
}
