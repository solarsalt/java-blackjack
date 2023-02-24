package blackjack.domain.member;

import blackjack.domain.card.CardDeck;
import blackjack.domain.result.PlayerResult;
import blackjack.view.BlackJackInputView;
import blackjack.view.YesNoType;

import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> toList() {
        return players;
    }

    public void hit(CardDeck cardDeck) {
        players.forEach(player -> hitTurn(cardDeck, player));
    }

    private void hitTurn(CardDeck cardDeck, Player player) {
        while (true) {
            YesNoType hit = BlackJackInputView.getHitYesNo(player.getName());
            if (hit.isYes()) {
                player.pickCard(cardDeck.pickOne());
            } else {
                return;
            }
        }
    }

    public List<PlayerResult> getResults(Integer dealerScore) {
        return players.stream()
                .map(player -> new PlayerResult(player, player.winOrLose(dealerScore)))
                .collect(Collectors.toList());
    }
}
