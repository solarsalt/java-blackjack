package blackjack.domain.member;

import blackjack.domain.YesNoType;
import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;
import blackjack.domain.result.GameResult;
import blackjack.domain.result.GameResultReport;

public class Player implements GameMember {
    private String name;
    private CardBundle cardBundle;
    private Integer score = 0;

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
        if(dealerScore < this.score) {
            return GameResult.WIN;
        }
        if (dealerScore > this.score) {
            return GameResult.LOSE;
        }
        return GameResult.DRAW;
    }
}
