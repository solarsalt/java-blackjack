package blackjack.service;

import blackjack.domain.card.CardDeck;
import blackjack.domain.member.GameMemberGroup;
import blackjack.view.OutputView;

public class StartingCardPicker {
    private GameMemberGroup gameMemberGroup;
    private CardDeck cardDeck;

    public StartingCardPicker(GameMemberGroup gameMemberGroup,
                              CardDeck cardDeck) {
        this.gameMemberGroup = gameMemberGroup;
        this.cardDeck = cardDeck;
    }

    public void pickStartingCards() {
        gameMemberGroup.pickStartingCards(cardDeck);
        OutputView.showAllStartingCard(gameMemberGroup);
    }
}
