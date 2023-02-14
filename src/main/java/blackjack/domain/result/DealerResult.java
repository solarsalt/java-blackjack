package blackjack.domain.result;

import blackjack.domain.member.Dealer;
import java.util.Map;

public class DealerResult {
    Dealer dealer;
    Map<GameResult,Integer> gameResult;

    public String getGameResult() {
        return "";
    }
}
