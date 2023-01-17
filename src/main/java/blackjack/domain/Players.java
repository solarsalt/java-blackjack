package blackjack.domain;

import blackjack.service.PlayersValidator;
import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }
}
