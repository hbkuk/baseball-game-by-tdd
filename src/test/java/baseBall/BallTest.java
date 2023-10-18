package baseBall;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallTest {

    @Test
    void create() {
        Ball ball = new Ball(1, 1);
        assertThat(ball).isEqualTo(new Ball(1, 1));
    }

    @Test
    @DisplayName("Ball은 position과 number가 같다면 Strike 상태를 반환한다.")
    void strike() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.match(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Ball은 position은 다르고 number가 같다면 Ball 상태를 반환한다.")
    void ball() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.match(new Ball(3, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Ball은 position은 다르고 number도 다르다면 nothing 상태를 반환한다.")
    void nothing() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.match(new Ball(3, 3))).isEqualTo(BallStatus.NOTHING);
    }

    @DisplayName("Ball의 숫자는 최소 1 이상, 최대 9 이하의 숫자를 전달받아서 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 9})
    void create_number_valid_range(int number) {
        new Ball(1, number);
    }

    @DisplayName("Ball의 숫자는 최소 1 이상, 최대 9 이하의 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 100})
    void create_invalid_range(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Ball(1, number);
                })
                .withMessageMatching("Ball의 숫자는 최소 1 이상, 최대 9 이하의 숫자여야만 합니다.");
    }

    @DisplayName("Ball의 위치는 최소 1 이상, 최대 3 이하의 숫자를 전달받아서 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void create_valid_position(int position) {
        new Ball(position, 1);
    }

    @DisplayName("Ball의 위치가 최소 1 이상, 최대 3 이하의 숫자가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10, 100})
    void create_invalid_position(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Ball(position, 1);
                })
                .withMessageMatching("Ball의 위치는 최소 1 이상, 최대 3 이하의 숫자여야만 합니다.");
    }
}
