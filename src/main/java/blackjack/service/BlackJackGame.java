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
        StartingCardStage startingCardStage = new StartingCardStage(gameMemberGroup, cardDeck);
        startingCardStage.pickStartingCards();
        hit(cardDeck);
        showScores(gameMemberGroup);
        showResults(players,dealer);
    }

    private void hit(CardDeck cardDeck) {
        players.hit(cardDeck);
        dealer.hit(cardDeck);
    }

    private static void showScores(GameMemberGroup gameMemberGroup) {
        ScoreRecorder scoreRecorder = new ScoreRecorder(gameMemberGroup);
        scoreRecorder.record();
        OutputView.showTotalScore(gameMemberGroup);
    }

    private void showResults(Players players, Dealer dealer) {
        GameResultJudge gameResultJudge = new GameResultJudge(dealer, players);
        OutputView.showGameResult(gameResultJudge.judgeGamResult());
    }
}
