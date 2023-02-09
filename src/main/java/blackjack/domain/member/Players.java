package blackjack.domain.member;

import blackjack.view.BlackJackInputView;
import blackjack.view.OutputView;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> toList() {
        return players;
    }

    public void hit() {
        players.stream()
                .forEach(
                        player -> {
                            BlackJackInputView blackJackInputView = new BlackJackInputView();
                            boolean isHit = blackJackInputView.getHit();
                            player.hit();
                            // y이면, pick
                            // n이면, 종료
                        }
                );
    }
}
