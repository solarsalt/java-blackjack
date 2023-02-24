package blackjack.service;

import blackjack.domain.member.Player;

import java.util.List;

public class PlayersValidator {
    private static final int MAX_PLAYERS_NUMBER = 8;
    private static final int MIN_PLAYERS_NUMBER = 2;

    public static boolean isValidPlayerNumber(List<Player> players) {
        return (players.size() >= MIN_PLAYERS_NUMBER)
                && (players.size() <= MAX_PLAYERS_NUMBER);
    }

}
