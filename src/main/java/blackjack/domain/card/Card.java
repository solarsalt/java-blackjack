package blackjack.domain.card;

public class Card {
    private Suit suit;
    private Rank rank;
    private int score;

    private int aceRuleScore = 10;
    private int aceMinScore = 1;
    private int aceMaxScore = 11;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getCardInfo() {
        return suit.getLabel() + rank.getLabel();
    }

    public int getNormalScore() {
        switch (rank) {
            case J: case Q: case K:
                score = 10;
                break;
            default:
                score = rank.getScore();
        }
        return score;
    }

    public int getAceScore(int otherSum) {
        if(otherSum > aceRuleScore) {
            return aceMinScore;
        }
        return aceMaxScore;
    }

    public boolean isAce() {
        return this.rank == Rank.A;
    }
}
