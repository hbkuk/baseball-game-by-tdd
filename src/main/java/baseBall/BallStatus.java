package baseBall;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isNothing() {
        return this == NOTHING;
    }
}
