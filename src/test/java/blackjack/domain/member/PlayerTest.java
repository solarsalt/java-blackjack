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

class PlayerTest {
    Player player;
    private static CardBundle cardBundle;

    @BeforeEach
    void initPlayer() {
        player = new Player("tester");
    }

    @BeforeAll
    static void initCardBundle() {
        Card heart = new Card(Suit.HEART, Rank.NINE);
        Card diamond = new Card(Suit.DIAMOND, Rank.NINE);
        cardBundle = new CardBundle(List.of(heart, diamond));
    }

    @Test
    @DisplayName("플레이어는 2장의 시작 카드를 받는다")
    void addStartingCards() {
        //when
        player.pickStartingCards(cardBundle);
        //then
        assertEquals(2, player.getCardBundle().size());
    }

    @Test
    @DisplayName("플레이어의 시작 카드 정보를 노출")
    void getStartingCardInfo() {
        //when
        player.pickStartingCards(cardBundle);
        String startingCardInfo = player.getStartingCardInfo();
        //then
        assertEquals("tester : 하트9, 다이아몬드9",startingCardInfo);
    }
}