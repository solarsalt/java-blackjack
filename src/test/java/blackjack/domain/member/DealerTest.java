package blackjack.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.Card;
import blackjack.domain.CardBundle;
import blackjack.domain.Rank;
import blackjack.domain.Suit;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {
    Dealer dealer;
    private static CardBundle cardBundle;

    @BeforeEach
    void initDealer() {
        dealer = new Dealer();
    }

    @BeforeAll
    static void initCardBundle() {
        Card heart = new Card(Suit.HEART, Rank.NINE);
        Card diamond = new Card(Suit.DIAMOND, Rank.NINE);
        cardBundle = new CardBundle(List.of(heart, diamond));
    }

    @Test
    @DisplayName("딜러는 2장의 시작 카드를 받는다")
    void addStartingCards() {
        //when
        dealer.pickStartingCards(cardBundle);
        //then
        assertEquals(2, dealer.getCardBundle().size());
    }

    @Test
    @DisplayName("딜러의 시작 카드정보는 1개 카드정보만 노출")
    void getStartingCardInfo() {
        //when
        dealer.pickStartingCards(cardBundle);
        String startingCardInfo = dealer.getStartingCardInfo();
        //then
        assertEquals("딜러 : 하트9", startingCardInfo);
    }
}