package blackjack.domain.member;

import blackjack.domain.CardBundle;

public interface GameMember {
    CardBundle getCardBundle();

    void moreCard();

    void addStartingCards(CardBundle cards);

    String getStartingCardInfo();

    String getName();
}
