package baseBall;

import java.util.Scanner;

public class GameManager {

    private static final String RESTART_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INVALID_INPUT_RESTART_PROMPT = "다시 제대로 숫자를 입력해 주세요 : ";
    private static final String INPUT_PROMPT = "숫자를 입력해 주세요 : ";
    private final Scanner scanner;

    public GameManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        boolean gameContinue = true;
        while (gameContinue) {
            playSingleGame(createComputerBall());
            gameContinue = askUserForRestart();
        }
        scanner.close();
    }

    public void playSingleGame(Balls balls) {
        boolean gameFinished = true;
        while (gameFinished) {
            String inputNumbers = getInput();
            BallStatusResult ballStatusResult =
                    balls.match(new Balls(InputView.splitStringToIntegerList(inputNumbers)));

            System.out.println(ResultView.result(ballStatusResult));

            if (ballStatusResult.isThreeStrike()) {
                gameFinished = false;
            }
        }
    }

    public boolean askUserForRestart() {
        System.out.println(RESTART_PROMPT);

        String inputConditionNumber = scanner.next();
        while (!InputView.isValidInputConditionNumber(inputConditionNumber)) {
            System.out.println(INVALID_INPUT_RESTART_PROMPT);
            inputConditionNumber = scanner.next();
        }
        return !InputView.isExitNumber(inputConditionNumber);
    }

    public String getInput() {
        String inputNumbers;
        do {
            System.out.println(INPUT_PROMPT);
            inputNumbers = scanner.next();
        } while (!InputView.isValidInputNumber(inputNumbers));
        return inputNumbers;
    }

    private Balls createComputerBall() {
        UniqueRandomBallNumberGenerator uniqueRandomBallNumberGenerator = new UniqueRandomBallNumberGenerator();
        return new Balls(uniqueRandomBallNumberGenerator.generate());
    }
}
