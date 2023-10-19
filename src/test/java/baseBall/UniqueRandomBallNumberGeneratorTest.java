package baseBall;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueRandomBallNumberGeneratorTest {

    @Test
    @DisplayName("숫자를 랜덤 생성한다.")
    void create() {
        UniqueRandomBallNumberGenerator uniqueRandomNumberGenerator = new UniqueRandomBallNumberGenerator();
        List<Integer> numbers = uniqueRandomNumberGenerator.generate();

        // 중복을 확인하기 위해 Set을 사용
        Set<Integer> numberSet = new HashSet<>(numbers);

        // 생성된 숫자 리스트의 크기는 3이어야 하며, Set의 크기와 같아야 함
        assertEquals(3, numbers.size());
        assertEquals(3, numberSet.size());
    }
}
