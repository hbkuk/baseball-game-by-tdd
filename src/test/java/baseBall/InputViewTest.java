package baseBall;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    @CsvSource(value = {"123:true", "012:false", "-134:false", "333:true", "1052:false"}, delimiter = ':')
    @ParameterizedTest
    void create(String inputNumbers, boolean expected) {
        assertEquals(expected, InputView.isValidInput(inputNumbers));
    }

    @Test
    void split() {
        String inputNumbers = "123";
        List<Integer> integers = InputView.splitStringToIntegerList(inputNumbers);

        assertEquals(1, integers.get(0));
        assertEquals(2, integers.get(1));
        assertEquals(3, integers.get(2));
    }
}
