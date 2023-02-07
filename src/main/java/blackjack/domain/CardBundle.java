package blackjack.domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Random;
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
        String allCardInfo = this.cards.stream()
                .map(Card::getCardInfo)
                .collect(Collectors.joining(", "));
        return allCardInfo;
    }

    public String getFirstCardInfo() {
        return this.cards.get(0).getCardInfo();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    // todo 적절한 예외로 변경
    public Card toCard() throws InvalidParameterException {
        if(cards.size() == 1) {
            return cards.get(0);
        }
        throw new InvalidParameterException();
    }
}
