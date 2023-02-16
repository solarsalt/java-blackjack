package blackjack.domain.result;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultReport {
    private final DealerResult dealerResult;
    private final List<PlayerResult> playerResults;

    public GameResultReport(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
        this.dealerResult = calculateDealerResults();
    }

    private DealerResult calculateDealerResults() {
        List<GameResult> gameResults = playerResults.stream()
                .map(PlayerResult::getOpponentResult)
                .collect(Collectors.toList());
        return new DealerResult(gameResults);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dealerResult.report());
        for (PlayerResult playerResult:playerResults) {
            stringBuilder.append(playerResult.report());
        }
        return stringBuilder.toString();
    }
}
