package blackjack.domain.result;

import blackjack.domain.member.Player;
import blackjack.domain.member.Players;

public class PlayerResult {
    private Player player;
    private GameResult gameResult;

    public PlayerResult(Player player,
                        GameResult gameResult) {
        this.player = player;
        this.gameResult = gameResult;
    }

    public GameResult getOpponentResult() {
        return this.gameResult.getOpponentResult();
    }

    public String report() {
        return player.getName() + ": " + gameResult.getDescription();
    }
}
