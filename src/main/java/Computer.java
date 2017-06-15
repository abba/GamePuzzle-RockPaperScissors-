import java.util.Random;

/**
 * Created by zsuleiman on 10/06/2017.
 */
public class Computer {

    public static RockPaperScissors.Move getMove() {
        RockPaperScissors.Move[] moves = RockPaperScissors.Move.values();
        Random random = new Random();
        int index = random.nextInt(moves.length);
        return moves[index];


    }
}
