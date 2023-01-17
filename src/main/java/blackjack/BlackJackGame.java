package blackjack;

import blackjack.view.PlayerNameInputView;
import java.util.List;

public class BlackJackGame {
    public void play() {
        PlayerNameInputView playerNameInputView = new PlayerNameInputView();
        List<String> playerNames = playerNameInputView.getPlayerNames();
    }
}
