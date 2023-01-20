package blackjack.service;

import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.service.PlayersValidator;
import blackjack.view.OutputView;
import blackjack.view.PlayerNameInputView;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackGame {
    private Players players;

    public void play() {
        setPlayers();
    }

    private void setPlayers() {
        while (true) {
            List<Player> playersFromInput = getInputNames();
            if (PlayersValidator.isValidPlayerNumber(playersFromInput)) {
                players = new Players(playersFromInput);
                break;
            }
            OutputView.showInvalidPlayersError();
        }
    }

    private static List<Player> getInputNames() {
        PlayerNameInputView playerNameInputView = new PlayerNameInputView();
        return playerNameInputView.getPlayerNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }
}
