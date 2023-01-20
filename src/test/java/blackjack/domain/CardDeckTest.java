package blackjack.domain;

import static org.junit.jupiter.api.Assertions.*;

import blackjack.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardDeckTest {

    @Test
    @DisplayName("카드덱 생성 시, 52개 인지 검증")
    void createValidSizeCardDeck() {
        //when
        CardDeck cardDeck = CardDeck.create52CardDeck();
        //then
        assertEquals(52, cardDeck.getCards().size());
    }
}