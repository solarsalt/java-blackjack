package blackjack.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextParserTest {

    @Test
    @DisplayName("정상적인 delimiter를 포함한 경우, 파싱 정상 동작")
    void splitWithDelimiterText() {
        //given
        String withComma = "with,comma";
        //when
        List<String> textParser = TextParser.split(withComma, ",");
        //then
        assertThat(textParser.size()).isEqualTo(2);
        assertThat(textParser.get(0)).isEqualTo("with");
        assertThat(textParser.get(1)).isEqualTo("comma");
    }

    @Test
    @DisplayName("delimiter를 포함하지 않은 경우, 파싱 불가")
    void splitWithNoDelimiterText() {
        //given
        String withComma = "withoutcomma";
        //when
        List<String> textParser = TextParser.split(withComma, ",");
        //then
        assertThat(textParser.size()).isEqualTo(1);
        assertThat(textParser.get(0)).isEqualTo("withoutcomma");
    }
}