package blackjack.domain.result;

import java.util.List;

public class DealerResult {
    List<GameResult> gameResults;

    public DealerResult(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public String report() {
        long winCount = getSameResultCount(GameResult.WIN);
        long loseCount = getSameResultCount(GameResult.LOSE);
        long drawCount = getSameResultCount(GameResult.LOSE);
        return "딜러: " + winCount + GameResult.WIN.getDescription()
                + loseCount + GameResult.LOSE.getDescription()
                + drawCount + GameResult.DRAW.getDescription();
    }

    private long getSameResultCount(GameResult gameResult) {
        return gameResults.stream()
                .filter(result -> result == gameResult)
                .count();
    }
}
