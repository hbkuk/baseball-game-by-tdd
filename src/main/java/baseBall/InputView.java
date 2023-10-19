package baseBall;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {

    private static final String VALID_INPUT_NUMBER_REGEX = "^[1-9]{3}$";
    private static final String VALID_INPUT_CONDITION_NUMBER_REGEX = "^[1-2]{1}$";
    private static final String STRING_DELIMITER = "";
    private static final String GAME_EXIT_NUMBER = "2";

    public static boolean isValidInputNumber(String inputNumbers) {
        return Pattern.matches(VALID_INPUT_NUMBER_REGEX, inputNumbers);
    }

    public static List<Integer> splitStringToIntegerList(String inputString) {
        List<Integer> integers = new ArrayList<>();
        for (String input : inputString.split(STRING_DELIMITER)) {
            integers.add(Integer.parseInt(input));
        }
        return integers;
    }

    public static boolean isValidInputConditionNumber(String inputConditionNumber) {
        return Pattern.matches(VALID_INPUT_CONDITION_NUMBER_REGEX, inputConditionNumber);
    }

    public static boolean isExitNumber(String inputConditionNumber) {
        return inputConditionNumber.equals(GAME_EXIT_NUMBER);
    }
}