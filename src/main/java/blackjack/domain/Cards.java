package blackjack.domain;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return cards.size();
    }

    public List<Card> toList() {
        return cards;
    }

}
