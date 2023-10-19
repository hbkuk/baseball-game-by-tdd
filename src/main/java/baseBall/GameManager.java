package baseBall;

import java.util.Scanner;

public class GameManager {

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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String inputConditionNumber = scanner.next();
        while (!InputView.isValidInputConditionNumber(inputConditionNumber)) {
            System.out.println("다시 제대로 숫자를 입력해 주세요 : ");
            inputConditionNumber = scanner.next();
        }
        if (InputView.isExitNumber(inputConditionNumber)) {
            return false;
        }
        return true;
    }

    public String getInput() {
        String inputNumbers;
        do {
            System.out.println("숫자를 입력해 주세요 : ");
            inputNumbers = scanner.next();
        } while (!InputView.isValidInputNumber(inputNumbers));
        return inputNumbers;
    }

    private Balls createComputerBall() {
        UniqueRandomBallNumberGenerator uniqueRandomBallNumberGenerator = new UniqueRandomBallNumberGenerator();
        return new Balls(uniqueRandomBallNumberGenerator.generate());
    }
}
