package blackjack.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class TextParserTest {

    @Test
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