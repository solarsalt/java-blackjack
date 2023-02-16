package blackjack.service;

import blackjack.domain.member.Dealer;
import blackjack.domain.member.Player;
import blackjack.domain.member.Players;
import blackjack.view.OutputView;
import blackjack.view.BlackJackInputView;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayersMaker {

    public Players createPlayers() {
        while (true) {
            List<Player> playersFromInput = createFromInputNames();
            if (PlayersValidator.isValidPlayerNumber(playersFromInput)) {
                return new Players(playersFromInput);
            }
            OutputView.showInvalidPlayersError();
        }
    }

    private static List<Player> createFromInputNames() {
        BlackJackInputView blackJackInputView = new BlackJackInputView();
        return blackJackInputView.getPlayerNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public Dealer createDealer() {
        return new Dealer();
    }
}
