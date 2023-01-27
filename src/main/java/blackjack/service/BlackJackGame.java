package blackjack.service;

import blackjack.domain.CardDeck;
import blackjack.domain.CardBundle;
import blackjack.domain.member.Dealer;
import blackjack.domain.member.GameMember;
import blackjack.domain.member.Players;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BlackJackGame {
    private Players players;
    private Dealer dealer;
    private CardDeck cardDeck;

    public void play() {
        players = new GamePlayersMaker().createPlayers();
        dealer = new GamePlayersMaker().createDealer();
        cardDeck = CardDeck.create52CardDeck();
        pickStartingCards();
    }
    // todo 리팩토링 : GameMembers 를 players,dealer로 생성
    //  picked CardBundle 을 받아서, 셀프로 모든 멤버의 addStartingCards 를 함
    //  게임멤버가 멤버 전원의 이름을 리턴하고, OutputView는 텍스트 출력만 담당
    private void pickStartingCards() {
        List<GameMember> gameMembers = new ArrayList<>(players.toList());
        gameMembers.add(dealer);
        gameMembers.forEach(player -> {
            CardBundle picked = cardDeck.pickStartingCardBundle();
            player.addStartingCards(picked);
        });
        OutputView.showAllStartingCard(gameMembers);
    }
}
