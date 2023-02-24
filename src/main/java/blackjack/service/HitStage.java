package blackjack.service;

import blackjack.domain.card.CardDeck;
import blackjack.domain.member.Dealer;
import blackjack.domain.member.Players;

public class HitStage {
    private Players players;
    private Dealer dealer;

    public HitStage(Players players,
                    Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void hit(CardDeck cardDeck) {
        players.hit(cardDeck);
        dealer.hit(cardDeck);
    }
}
