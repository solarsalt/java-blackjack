package blackjack.service;

import blackjack.domain.card.CardDeck;
import blackjack.domain.member.Dealer;
import blackjack.domain.member.GameMemberGroup;
import blackjack.domain.member.Players;
import blackjack.view.OutputView;

public class BlackJackGame {
    private Players players;
    private Dealer dealer;

    public BlackJackGame(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void play() {
        GameMemberGroup gameMemberGroup = new GameMemberGroup(players, dealer);
        CardDeck cardDeck = CardDeck.create52CardDeck();
        playCard(gameMemberGroup, cardDeck);

        showScores(gameMemberGroup);
        showResults(players, dealer);
    }

    private void playCard(GameMemberGroup gameMemberGroup, CardDeck cardDeck) {
        StartingCardStage startingCardStage = new StartingCardStage(gameMemberGroup, cardDeck);
        startingCardStage.pickStartingCards();
        HitStage hitStage = new HitStage(players, dealer);
        hitStage.hit(cardDeck);
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
