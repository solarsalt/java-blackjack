package blackjack.domain.member;

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
    public void moreCard() {
        // todo 1장의 카드 더 받기
    }

    @Override
    public void pickStartingCards(CardBundle cards) {
        this.cardBundle = cards;
    }

    @Override
    public String getStartingCardInfo() {
        return this.name + " : " + this.getCardBundle().getAllCardInfo();
    }
}
