package baseBall;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final String VALID_INPUT_REGEX = "^[1-9]{3}$";
    private static final String STRING_DELIMITER = "";

    public static boolean isValidInput(String inputNumbers) {
        return Pattern.matches(VALID_INPUT_REGEX, inputNumbers);
    }

    public static List<Integer> splitStringToIntegerList(String inputString) {
        List<Integer> integers = new ArrayList<>();
        for (String input : inputString.split(STRING_DELIMITER)) {
            integers.add(Integer.parseInt(input));
        }
        return integers;
    }
}