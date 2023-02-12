package blackjack.domain;

import java.util.Arrays;

public enum YesNoType {
    Y,
    N;

    public static boolean contains(String Yn) {
        return Arrays.stream(values())
                .anyMatch(yesNoType -> yesNoType.name().equals(Yn));
    }

    public boolean isYes() {
        return this.equals(Y);
    }
}
