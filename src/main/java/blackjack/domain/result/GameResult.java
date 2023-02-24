package blackjack.domain.result;

public enum GameResult {
    WIN("승"),
    LOSE("패"),
    DRAW("무");
    private final String description;

    GameResult(String description) {
        this.description = description;
    }

    public GameResult getOpponentResult() {
        if (this == WIN) {
            return LOSE;
        }
        if (this == LOSE) {
            return WIN;
        }
        return DRAW;
    }

    public String getDescription() {
        return this.description;
    }
}
