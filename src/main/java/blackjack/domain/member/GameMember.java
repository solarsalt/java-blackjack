package blackjack.domain.member;

import blackjack.domain.Card;
import blackjack.domain.CardBundle;

public interface GameMember {
    CardBundle getCardBundle();

    void pickCard(Card card);

    void pickStartingCards(CardBundle cards);

    String getStartingCardInfo();

    String getName();

    boolean isDealer();

    boolean isPlayer();
}
