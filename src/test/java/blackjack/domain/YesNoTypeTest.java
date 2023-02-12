package blackjack.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class YesNoTypeTest {
    @DisplayName("대소문자 Y 또는 N 이면, 유효한 YesNoType")
    @ParameterizedTest()
    @ValueSource(strings = {"Y", "N"})
    void containsSuccess(String inputYn) {
        assertTrue(YesNoType.contains(inputYn));
    }

    @ParameterizedTest()
    @DisplayName("대문자 Y 또는 N 이외의 값이면, enum에 포함되지 않음")
    @ValueSource(strings = {"A","Z","y","n"})
    void containsFail(String inputYn) {
        assertFalse(YesNoType.contains(inputYn));
    }
}