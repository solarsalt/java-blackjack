package blackjack.domain.member;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardBundle;

public interface GameMember {
    CardBundle getCardBundle();

    void pickCard(Card card);

    void pickStartingCards(CardBundle cards);

    String getStartingCardInfo();

    String getName();

    String getAllCardInfo();

    Integer getScore();

    void recordScore(int totalScore);

    String getScoreInfo();
}
