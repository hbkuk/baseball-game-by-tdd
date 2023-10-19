package baseBall;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameManagerTest {

    @Test
    void getInput() {
        String input = "abs" + System.lineSeparator() + "123" + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameManager gameManager = new GameManager(new Scanner(System.in));
        assertEquals("123", gameManager.getInput());

        String expectedOutput = String.format("숫자를 입력해 주세요 : %n숫자를 입력해 주세요 : %n");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void askUserForRestart() {
        String input = "5" + System.lineSeparator() + "1" + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameManager gameManager = new GameManager(new Scanner(System.in));
        assertEquals(true, gameManager.askUserForRestart());

        String expectedOutput = String.format("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n다시 제대로 숫자를 입력해 주세요 : %n");
        assertEquals(expectedOutput, out.toString());
    }

    @Test
    void playSingleGame() {
        String input = "312" + System.lineSeparator() + "123" + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameManager gameManager = new GameManager(new Scanner(System.in));
        gameManager.playSingleGame(new Balls(Arrays.asList(1, 2, 3)));

        assertThat(out.toString()).contains("Ball 3", "All Strike!!!");
    }
}
