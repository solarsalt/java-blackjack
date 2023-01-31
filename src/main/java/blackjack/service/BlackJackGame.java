package blackjack.service;

import blackjack.domain.CardDeck;
import blackjack.domain.member.Dealer;
import blackjack.domain.member.GameMemberGroup;
import blackjack.domain.member.Players;
import blackjack.view.OutputView;

public class BlackJackGame {
    private Players players;
    private Dealer dealer;
    private CardDeck cardDeck;

    public void play() {
        players = new GamePlayersMaker().createPlayers();
        dealer = new GamePlayersMaker().createDealer();
        cardDeck = CardDeck.create52CardDeck();
        pickStartingCards(players,dealer);
    }

    private void pickStartingCards(Players players, Dealer dealer) {
        GameMemberGroup gameMemberGroup = new GameMemberGroup(players,dealer);
        gameMemberGroup.pickStartingCards(cardDeck);
        OutputView.showAllStartingCard(gameMemberGroup);
    }
}
