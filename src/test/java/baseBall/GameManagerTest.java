package baseBall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameManagerTest {

    OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("정상적인 숫자로 구성된 문자열을 받을 때까지 특정 출력을 반복하고, 정상적인 숫자로 구성된 해당 문자열을 반환한다.")
    void getInput() {
        setInputStreamInSystem("abs", "123");

        GameManager gameManager = new GameManager(new Scanner(System.in));

        assertEquals("123", gameManager.getInput());
        assertExpectedOutput("숫자를 입력해 주세요 : %n숫자를 입력해 주세요 : %n");
    }

    @DisplayName("숫자로 구성된 하나의 문자열(1 혹은 2)를 받을 때까지 특정 출력을 반복하고, 1이라면 true, 2라면 false 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void askUserForRestart_true(String input, boolean expected) {
        setInputStreamInSystem("5", input);

        GameManager gameManager = new GameManager(new Scanner(System.in));

        assertEquals(expected, gameManager.askUserForRestart());
        assertExpectedOutput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.%n다시 제대로 숫자를 입력해 주세요 : %n");
    }

    @DisplayName("숫자로 구성된 값을 전달하면 결과를 출력한다.")
    @Test
    void playSingleGame() {
        setInputStreamInSystem("312", "123");

        GameManager gameManager = new GameManager(new Scanner(System.in));
        gameManager.playSingleGame(new Balls(Arrays.asList(1, 2, 3)));

        assertThat(out.toString()).contains("Ball 3", "All Strike!!!");
    }

    private void assertExpectedOutput(String format) {
        String expectedOutput = String.format(format);
        assertEquals(expectedOutput, out.toString());
    }

    private void setInputStreamInSystem(String inputA, String inputB) {
        String input = inputA + System.lineSeparator() + inputB + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
