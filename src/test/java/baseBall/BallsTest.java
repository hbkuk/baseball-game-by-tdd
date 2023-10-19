package baseBall;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BallsTest {

    static Balls balls;

    @BeforeAll
    static void setBall() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼을 비교 후 BALL 상태를 반환한다.")
    void ball() {
        BallStatus ballStatus = balls.match(new Ball(1, 3));
        assertEquals(BallStatus.BALL, ballStatus);
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼을 비교 후 STRIKE 상태를 반환한다.")
    void strike() {
        BallStatus ballStatus = balls.match(new Ball(3, 3));
        assertEquals(BallStatus.STRIKE, ballStatus);
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼을 비교 후 NOTHING 상태를 반환한다.")
    void nothing() {
        BallStatus ballStatus = balls.match(new Ball(3, 9));
        assertEquals(BallStatus.NOTHING, ballStatus);
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼들을 비교해서 Nothing 을 반환한다.")
    void all_match_nothing() {
        BallStatusResult ballStatusResult = balls.match(new Balls(Arrays.asList(4,5,6)));
        assertThat(ballStatusResult.isNothing()).isTrue();
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼들을 비교해서 1 Ball을 반환한다.")
    void match_1_ball() {
        BallStatusResult ballStatusResult = balls.match(new Balls(Arrays.asList(3,5,6)));
        assertEquals(1, ballStatusResult.getBallCount());
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼들을 비교해서 3 Ball을 반환한다.")
    void match_3_ball() {
        BallStatusResult ballStatusResult = balls.match(new Balls(Arrays.asList(3,1,2)));
        assertEquals(3, ballStatusResult.getBallCount());
    }

    @Test
    @DisplayName("Balls가 가지고 있는 볼들과 전달받은 볼들을 비교해서 3 Strike를 반환한다.")
    void match_3_strike() {
        BallStatusResult ballStatusResult = balls.match(new Balls(Arrays.asList(1,2,3)));
        assertEquals(3, ballStatusResult.getStrikeCount());
    }

    private List<BallStatus> getBallStatuses(List<BallStatus> ballsStatus, BallStatus ballStatusOnly) {
        return ballsStatus.stream()
                .filter(ballStatus -> ballStatus == ballStatusOnly)
                .collect(Collectors.toList());
    }
}
