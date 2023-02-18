package blackjack.domain.member;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;
import blackjack.domain.result.GameResult;

public class Player implements GameMember {
    private String name;
    private CardBundle cardBundle;
    private Integer score = 0;
    /* 버스트 룰에 따라 플레이어 카드 점수합이 21을 초과하면, 버스트로 플레이어가 패함 */
    private final static Integer BUST_RULE_SCORE = 21;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CardBundle getCardBundle() {
        return cardBundle;
    }

    @Override
    public void pickCard(Card card) {
        cardBundle.add(card);
    }

    @Override
    public void pickStartingCards(CardBundle cards) {
        this.cardBundle = cards;
    }

    @Override
    public String getStartingCardInfo() {
        return this.name + " : " + this.getCardBundle().getAllCardInfo();
    }

    @Override
    public boolean isDealer() {
        return false;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public void recordScore(int totalScore) {
        this.score = totalScore;
    }

    @Override
    public String getScoreInfo() {
        return "- 결과 : " + String.valueOf(this.score);
    }

    @Override
    public String getAllCardInfo() {
        return this.name + " : " + this.getCardBundle().getAllCardInfo();
    }

    @Override
    public Integer getScore() {
        return this.score;
    }

    public GameResult winOrLose(int dealerScore) {
        if (this.score > BUST_RULE_SCORE) {
            return GameResult.LOSE;
        }
        if (dealerScore < this.score) {
            return GameResult.WIN;
        }
        if (dealerScore > this.score) {
            return GameResult.LOSE;
        }
        return GameResult.DRAW;
    }
}
