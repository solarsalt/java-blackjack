package blackjack.domain;

public enum Rank {
    A("A", 1),
    TWO("2", 2),
    THRRE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    J("J", 10),
    Q("Q", 10),
    K("K", 10);
    private final String label;
    private int score;

    Rank(String label, int score) {
        this.label = label;
        this.score = score;
    }

    public String getLabel() {
        return this.label;
    }

    public int getScore() {
        return this.score;
    }
}
