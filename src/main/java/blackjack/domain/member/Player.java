package blackjack.domain.member;

import blackjack.domain.Card;
import blackjack.domain.CardBundle;

public class Player implements GameMember {
    private String name;
    private CardBundle cardBundle;

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

    public void hit() {
        // todo
    }
}
