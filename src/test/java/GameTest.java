import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by zsuleiman on 10/06/2017.
 */
public class GameTest {

    RockPaperScissors game;

    @Before
    public void setUp() {

        game = new RockPaperScissors();

    }

    @Rule
    public final StandardOutputStreamLog consoleLog = new StandardOutputStreamLog();
    @Rule
    public final TextFromStandardInputStream userInputMock = emptyStandardInputStream();


    @Test(expected = Exception.class)
    public void invalidGameMode() {

        userInputMock.provideText("3");
        game.getGameMode();
        assertThat(consoleLog.getLog(), containsString("invalid"));

    }

    @Test
    public void validGameMode() {

        userInputMock.provideText("1");
        game.chooseGameMode(1);
        assertThat(consoleLog.getLog(), containsString("You chose"));

    }

    @Test
    public void computerVsUser() {

        userInputMock.provideText("2");
        game.playerVsComputer();
        assertThat(consoleLog.getLog(), containsString("You played"));


    }

    @Test
    public void computerVsComputer() {

        game.computerVsComputer();
        assertThat(consoleLog.getLog(), anyOf(containsString("Tie"),
                containsString("beats")));

    }


    @Test
    public void winOrLoseGame() {

        userInputMock.provideText("2");
        game.playerVsComputer();
        assertThat(consoleLog.getLog(), anyOf(containsString("won"),
                containsString("lost"), containsString("Tie")));

    }

    @Test
    public void validPlayerMove() {
        userInputMock.provideText("2");
        game.playerVsComputer();
        assertThat(consoleLog.getLog(),containsString("PAPER"));

    }

    @Test(expected= NullPointerException.class)
    public void invalidPlayerMove() {

        userInputMock.provideText("4");
        game.playerVsComputer();
        assertThat(consoleLog.getLog(),null);

    }


}
