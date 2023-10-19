package baseBall;

import java.util.Objects;

public class Ball {

    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 9;

    private static final int MIN_POSITION_VALUE = 1;
    private static final int MAX_POSITION_VALUE = 3;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validateBall(position, number);
        this.position = position;
        this.number = number;
    }

    public BallStatus match(Ball ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if(isSameBallNumber(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isSameBallNumber(Ball ball) {
        return this.number == ball.number;
    }

    private void validateBall(int position, int number) {
        if(number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE) {
            throw new IllegalArgumentException("Ball의 숫자는 최소 1 이상, 최대 9 이하의 숫자여야만 합니다.");
        }
        if(position < MIN_POSITION_VALUE || position > MAX_POSITION_VALUE) {
            throw new IllegalArgumentException("Ball의 위치는 최소 1 이상, 최대 3 이하의 숫자여야만 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
