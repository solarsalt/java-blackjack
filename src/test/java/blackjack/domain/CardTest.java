package blackjack.domain;

import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.card.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("Rank가 숫자일때, 카드정보 정상")
    public void getCardInfoWithNRankNumber() {
        // given
        Card card = new Card(Suit.HEART, Rank.FIVE);
        // when
        String cardInfo = card.getCardInfo();
        // then
        assertEquals("하트5", cardInfo);
    }

    @Test
    @DisplayName("Rank가 알파벳일때, 카드정보 정상")
    public void getCardInfoWithRankWord() {
        // given
        Card card = new Card(Suit.HEART, Rank.J);
        // when
        String cardInfo = card.getCardInfo();
        // then
        assertEquals("하트J", cardInfo);
    }
}