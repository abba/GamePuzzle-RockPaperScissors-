import java.util.Scanner;


/**
 * Created by zsuleiman on 10/06/2017.
 */
public class RockPaperScissors {

    private Player player;
    private int userScore;
    private int computerScore;
    private int numberOfGames;
    private Scanner inputStream;

    public enum Move {
        ROCK, PAPER, SCISSORS;


        public int compareMoves(Move move) {

            if (this == move)
                return 0;

            switch (this) {
                case ROCK:
                    return (move == SCISSORS ? 1 : -1);
                case PAPER:
                    return (move == ROCK ? 1 : -1);
                case SCISSORS:
                    return (move == PAPER ? 1 : -1);
            }

            return 0;
        }
    }

    public RockPaperScissors() {

        player = new Player();
        inputStream = new Scanner(System.in);
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public void playerVsComputer() {

        Move userMove = Player.getMove();
        Move computerMove = Computer.getMove();

        displayMessage("\nYou played " + userMove + ".");
        displayMessage("Computer played " + computerMove + ".\n");

        int compareUserMoves = userMove.compareMoves(computerMove);
        switch (compareUserMoves) {
            case 0:
                displayMessage("Tie!");
                break;
            case 1:
                displayMessage(userMove + " beats " + computerMove + ". You won!");
                userScore++;
                break;
            case -1:
                displayMessage(computerMove + " beats " + userMove + ". You lost.");
                computerScore++;
                break;
        }
        numberOfGames++;


    }

    public void computerVsComputer() {

        Move computer1 = Computer.getMove();
        Move computer2 = Computer.getMove();
        int compareMoves = computer1.compareMoves(computer2);
        switch (compareMoves) {
            case 0:
                displayMessage("Tie!");
                break;
            case 1:
                displayMessage(computer1 + " beats " + computer2);
                userScore++;
                break;
            case -1:
                displayMessage(computer1 + " beats " + computer2);
                computerScore++;
                break;
        }
        numberOfGames++;

    }

    public void displayMessage(String message) {
        System.out.println(message);

    }


    public Integer getGameMode() {

        displayMessage("Choose a mode:\n 1 - Player vs. Computer\n 2 - Computer vs. Computer");

        int input = inputStream.nextInt();

        if (input == 1 | input == 2) {

            return input;
        }

        if (input <= 0 | input > 2) {

            displayMessage("Invalid Game Mode. Please try again.\n");
            startGame();

        }

        return input;
    }


    public int chooseGameMode(int mode) {

        switch (mode) {

            case 1:
                displayMessage("You chose Player vs. Computer\n");
                playerVsComputer();
                break;
            case 2:
                displayMessage("You chose Computer vs. Computer\n");
                computerVsComputer();
                break;
        }

        return mode;
    }

    public void startGame() {

        displayMessage("Welcome to Rock, Paper and Scissor!\n");
        chooseGameMode(getGameMode());

        if (player.retryGame()) {
            displayMessage("Game Restarted");
            startGame();
        } else {
            showGameStats();
        }
    }


    private void showGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;

        displayMessage(
                "Game Stats" + "\n" +
                        "Wins: " + wins + "\n" +
                        "Losses: " + losses + "\n" +
                        "Ties: " + losses + "\n"
                        + "Total Games:" + numberOfGames);

    }
}