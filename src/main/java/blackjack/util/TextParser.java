package blackjack.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {

    public static List<String> split(String text, String delimiter) {
        return Arrays.asList(text.split(delimiter));
    }

}
