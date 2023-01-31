package blackjack.domain.member;

import blackjack.domain.CardBundle;

public interface GameMember {
    CardBundle getCardBundle();

    void moreCard();

    void pickStartingCards(CardBundle cards);

    String getStartingCardInfo();

    String getName();
}
