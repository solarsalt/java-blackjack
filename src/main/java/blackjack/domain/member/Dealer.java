package blackjack.domain.member;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;
import blackjack.domain.card.CardDeck;

public class Dealer implements GameMember {
    private String name = "딜러";
    private CardBundle cardBundle;
    private int score = 0;
    /*
    딜러는 플레이어의 추가카드 받기가 모두 끝난 뒤에, 가진 카드의 점수 합계가 16 이하이면
    반드시 1장을 더 받아야 한다.(=HIT 해야한다.)
     */
    private static final int DEALER_HIT_SCORE_MIN = 16;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CardBundle getCardBundle() {
        return cardBundle;
    }

    @Override
    public void pickStartingCards(CardBundle cards) {
        this.cardBundle = cards;
    }

    @Override
    public String getStartingCardInfo() {
        return this.name + " : " + this.getCardBundle().getFirstCardInfo();
    }

    @Override
    public void pickCard(Card card) {
        cardBundle.add(card);
    }

    @Override
    public void recordScore(int totalScore) {
        this.score = totalScore;
    }

    @Override
    public String getScoreInfo() {
        return "- 결과 : " + String.valueOf(this.score);
    }

    public void hit(CardDeck cardDeck) {
        if (cardBundle.calculateTotalScore() <= DEALER_HIT_SCORE_MIN) {
            pickCard(cardDeck.pickOne());
        }
    }

    @Override
    public String getAllCardInfo() {
        return this.name + " : " + this.getCardBundle().getAllCardInfo();
    }

    public Integer getScore() {
        return this.score;
    }
}
