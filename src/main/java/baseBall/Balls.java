package baseBall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        balls = convertBalls(numbers);
    }

    private List<Ball> convertBalls(List<Integer> numbers) {
        List<Ball> convertBalls = new ArrayList<>();
        for (int i = 1; i <= numbers.size(); i++) {
            convertBalls.add(new Ball(i, numbers.get(i - 1)));
        }
        return convertBalls;
    }

    public BallStatus match(Ball givenBall) {
        return balls.stream()
                .map(ball -> ball.match(givenBall))
                .filter(ballStatus -> ballStatus != BallStatus.NOTHING)
                .findAny()
                .orElse(BallStatus.NOTHING);
    }

    public BallStatusResult match(Balls balls) {
        List<BallStatus> ballStatuses = balls.balls.stream()
                .map(this::match)
                .collect(Collectors.toList());
        return new BallStatusResult(ballStatuses);
    }
}
