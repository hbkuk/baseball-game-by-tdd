package baseBall;

import java.util.*;

public class UniqueRandomBallNumberGenerator {
    public static final int MAX_BALL_COUNT = 3;

    private Random random = new Random();

    public List<Integer> generate() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while(numbers.size() != MAX_BALL_COUNT) {
            numbers.add(random.nextInt(Ball.MAX_NUMBER_VALUE) + Ball.MIN_NUMBER_VALUE);
        }
        return new ArrayList<>(numbers);
    }
}
