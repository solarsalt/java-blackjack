package blackjack.service;

import blackjack.domain.card.CardDeck;
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
        GameMemberGroup gameMemberGroup = new GameMemberGroup(players, dealer);
        StartingCardPicker startingCardPicker = new StartingCardPicker(gameMemberGroup, cardDeck);
        startingCardPicker.pickStartingCards();
        hit(cardDeck);
        showResult(gameMemberGroup);
    }

    private void hit(CardDeck cardDeck) {
        players.hit(cardDeck);
        dealer.hit(cardDeck);
    }

    private static void showResult(GameMemberGroup gameMemberGroup) {
        OutputView.showTotalScore(gameMemberGroup);
        GameResultJudge gameResultJudge = new GameResultJudge(gameMemberGroup);
        OutputView.showGameResult(gameResultJudge);
    }
}
