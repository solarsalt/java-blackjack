package blackjack.domain.result;

public enum GameResult {
    WIN("승"),
    LOSE("패")
    ;
    private final String description;

    GameResult(String description) {
        this.description = description;
    }
}
