package blackjack.domain.member;

import java.util.List;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> toList() {
        return players;
    }
}
