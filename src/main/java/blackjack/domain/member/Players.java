package blackjack.domain.member;

import blackjack.view.YesNoType;
import blackjack.domain.card.CardDeck;
import blackjack.domain.result.PlayerResult;
import blackjack.view.BlackJackInputView;
import blackjack.view.OutputView;

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
        players.forEach(player -> {
                    hitTurn(cardDeck, player);
                }
        );
    }

    //todo 이사
    private void hitTurn(CardDeck cardDeck, Player player) {
        while (true) {
            YesNoType hit = getHit(player);
            if (hit.isYes()) {
                player.pickCard(cardDeck.pickOne());
            } else {
                return;
            }
        }
    }

    //todo 이사
    private YesNoType getHit(Player player) {
        while (true) {
            String inputHit = BlackJackInputView.getInputHit(player.getName());
            String yesNoInput = inputHit.toUpperCase();
            boolean isValidYn = YesNoType.contains(yesNoInput);
            if (isValidYn) {
                return YesNoType.valueOf(yesNoInput);
            }
            OutputView.showInvalidHitError();
        }
    }

    public List<PlayerResult> getResults(Integer dealerScore) {
        return players.stream()
                .map(player -> new PlayerResult(player, player.winOrLose(dealerScore)))
                .collect(Collectors.toList());
    }
}
