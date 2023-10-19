package baseBall;

import java.util.Scanner;

public class GameManager {

    void play() {
        Scanner scanner = new Scanner(System.in);

        boolean gameContinue = true;
        while (gameContinue) {
            playSingleGame(scanner);
            gameContinue = askUserForRestart(scanner);
        }
        scanner.close();
    }

    private void playSingleGame(Scanner scanner) {
        Balls computerBall = createComputerBall();

        boolean gameFinished = true;
        while (gameFinished) {
            String inputNumbers = getInput(scanner);
            BallStatusResult ballStatusResult =
                    computerBall.match(new Balls(InputView.splitStringToIntegerList(inputNumbers)));

            System.out.println(ResultView.result(ballStatusResult));

            if (ballStatusResult.isThreeStrike()) {
                gameFinished = false;
            }
        }
    }

    private boolean askUserForRestart(Scanner scanner) {
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

    private String getInput(Scanner scanner) {
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
