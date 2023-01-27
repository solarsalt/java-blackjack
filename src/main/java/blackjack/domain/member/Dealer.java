package blackjack.domain.member;

import blackjack.domain.CardBundle;

public class Dealer implements GameMember {
    private String name = "딜러";
    private CardBundle cardBundle;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CardBundle getCardBundle() {
        return cardBundle;
    }

    @Override
    public void moreCard() {

    }

    @Override
    public void addStartingCards(CardBundle cards) {
        this.cardBundle = cards;
    }

    @Override
    public String getStartingCardInfo() {
        return this.name + " : " + this.getCardBundle().getFirstCardInfo();
    }
}
