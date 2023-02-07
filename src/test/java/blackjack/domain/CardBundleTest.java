package blackjack.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardBundleTest {
    CardBundle cardBundle;
    Card heart;

    @BeforeEach
    void initCardBundle() {
        heart = new Card(Suit.HEART, Rank.NINE);
        Card diamond = new Card(Suit.DIAMOND, Rank.NINE);
        cardBundle = new CardBundle(List.of(heart, diamond));
    }

    @Test
    @DisplayName("count 갯수만큼, 카드가 선택된다. 선택 후, 카드 수는 count 만큼 줄어듬")
    void pickRandomCardsBy() {
        //given
        CardBundle cardDeck = CardDeck.create52CardDeck().getCards();
        Integer count = 2;
        //when
        CardBundle picked = cardDeck.pickRandomCardsBy(count);
        //then
        assertAll("cards",
                () -> assertEquals(2, picked.size()),
                () -> assertEquals(50, cardDeck.size())
        );
    }

    @Test
    @DisplayName("카드번들이 보유한 모든 카드 정보")
    void getAllCardInfo() {
        //when
        String allCardInfo = cardBundle.getAllCardInfo();
        //then
        assertEquals("하트9, 다이아몬드9", allCardInfo);
    }

    @Test
    @DisplayName("딜러의 최초 카드를 1개만 노출 시, 첫번째 카드정보를 노출")
    void getFirstCardInfo() {
        //when
        String firstCardInfo = cardBundle.getFirstCardInfo();
        //then
        assertEquals(heart.getCardInfo(), firstCardInfo);
    }

    //todo
    @Test
    void add() {

    }
}