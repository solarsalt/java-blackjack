package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CardBundle {
    private List<Card> cards;

    public CardBundle(List<Card> cards) {
        this.cards = cards;
    }

    public int size() {
        return cards.size();
    }

    public CardBundle pickRandomCardsBy(Integer count) {
        Collections.shuffle(cards);
        List<Card> pickedCards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Card pickedCard = cards.remove(0);
            pickedCards.add(pickedCard);
        }
        return new CardBundle(pickedCards);
    }

    public String getAllCardInfo() {
        return this.cards.stream()
                .map(Card::getCardInfo)
                .collect(Collectors.joining(", "));
    }

    public String getFirstCardInfo() {
        return this.cards.get(0).getCardInfo();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public Card toCard() throws IllegalStateException {
        if (cards.size() == 1) {
            return cards.get(0);
        }
        throw new IllegalStateException();
    }

    public int calculateTotalScore() {
        int sumWithoutAce = getSumWithoutAce();
        int aceScore = getAceScore(sumWithoutAce);
        return Integer.sum(sumWithoutAce, aceScore);
    }

    private int getSumWithoutAce() {
        return cards.stream()
                .filter(card -> !card.isAce())
                .mapToInt(Card::getNormalScore)
                .sum();
    }

    private int getAceScore(int sumWithoutAce) {
        return cards.stream()
                .filter(Card::isAce)
                .mapToInt(card -> card.getAceScore(sumWithoutAce))
                .sum();
    }
}
