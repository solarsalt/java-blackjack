package blackjack.domain.member;

import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.CardDeck;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameMemberGroupTest {
    static GameMemberGroup gameMemberGroup;
    static Players players;
    static Dealer dealer;

    @BeforeAll
    static void init() {
        Player tester = new Player("tester");
        Player solar = new Player("solar");
        dealer = new Dealer();
        players = new Players(List.of(tester, solar));
        gameMemberGroup = new GameMemberGroup(players, dealer);
    }

    @Test
    @DisplayName("시작 카드를 뽑으면, 멤버 모두 시작 카드를 2개씩 보유")
    void pickStartingCards() {
        //given
        CardDeck cardDeck = CardDeck.create52CardDeck();
        //when
        gameMemberGroup.pickStartingCards(cardDeck);
        //then
        gameMemberGroup.toList().forEach(
                gameMember->{
                    assertEquals(2,gameMember.getCardBundle().size());
                }
        );
    }

    @Test
    @DisplayName("게임 멤버 전원의 이름을 텍스트로 리턴")
    void getGameMemberNames() {
        //given
        //when
        String names = gameMemberGroup.getGameMemberNames();
        //then
        String expected = "tester, solar, 딜러";
        assertEquals(expected,names);
    }
}