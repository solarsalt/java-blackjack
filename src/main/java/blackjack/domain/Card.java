package blackjack.domain;

public class Card {
    private Suit suit;
    private Rank rank;
    private int number;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getCardInfo() {
        return suit.getLabel() + rank.getLabel();
    }
}
