package blackjack.service;

import blackjack.domain.member.Dealer;
import blackjack.domain.member.Players;
import blackjack.domain.result.GameResultReport;
import blackjack.domain.result.PlayerResult;
import java.util.List;
import java.util.stream.Collectors;

public class GameResultJudge {
    private Dealer dealer;
    private Players players;

    public GameResultJudge(Dealer dealer,
                           Players players) {
        this.dealer = dealer;
        this.players = players;
    }

    public GameResultReport judgeGamResult() {
        int dealerScore = dealer.getScore();
        List<PlayerResult> playerResults = players.getResults(dealerScore);
        return new GameResultReport(playerResults);
    }
}
