package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private CardBundle cards;
    private static final int STARTING_CARD_COUNT = 2;

    private CardDeck(CardBundle cards) {
        this.cards = cards;
    }

    /**
     * 4가지 종류의 suit 와 13 개의 rank 조합으로 52장의 카드 한 벌(deck)이 구성
     *
     * @return
     */
    public static CardDeck create52CardDeck() {
        List<Card> cardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(suit, rank));
            }
        }
        return new CardDeck(new CardBundle(cardDeck));
    }

    public CardBundle getCards() {
        return cards;
    }

    public CardBundle pickStartingCardBundle() {
        return cards.pickRandomCardsBy(STARTING_CARD_COUNT);
    }
}
