package baseBall;

import java.util.List;

public class BallStatusResult {

    private final int strikeCount;
    private final int ballCount;

    public BallStatusResult(List<BallStatus> ballStatuses) {
        this.strikeCount = getStatusCount(ballStatuses, BallStatus.STRIKE);
        this.ballCount = getStatusCount(ballStatuses, BallStatus.BALL);
    }

    private int getStatusCount(List<BallStatus> ballStatuses, BallStatus resultStatus) {
        return (int) ballStatuses.stream()
                .filter(ballStatus -> ballStatus == resultStatus)
                .count();
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
