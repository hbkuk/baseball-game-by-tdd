package baseBall;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultViewTest {

    @Test
    void strike() {
        BallStatusResult ballStatusResult =
                new BallStatusResult(Arrays.asList(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE));

        String result = ResultView.result(ballStatusResult);
        assertEquals(result, "All Strike!!!\n");
    }

    @Test
    void three_ball() {
        BallStatusResult ballStatusResult =
                new BallStatusResult(Arrays.asList(BallStatus.BALL, BallStatus.BALL, BallStatus.BALL));

        String result = ResultView.result(ballStatusResult);
        assertEquals(result, "Ball 3\n");
    }

    @Test
    void one_strike_two_ball() {
        BallStatusResult ballStatusResult =
                new BallStatusResult(Arrays.asList(BallStatus.STRIKE, BallStatus.BALL, BallStatus.BALL));

        String result = ResultView.result(ballStatusResult);
        assertEquals(result, "Strike 1\nBall 2\n");
    }
}
