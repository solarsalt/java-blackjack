package blackjack.service;

import blackjack.domain.CardDeck;
import blackjack.domain.member.GameMemberGroup;
import blackjack.view.OutputView;

public class StartingCardStage {
    private GameMemberGroup gameMemberGroup;
    private CardDeck cardDeck;

    public StartingCardStage(GameMemberGroup gameMemberGroup,
                             CardDeck cardDeck) {
        this.gameMemberGroup = gameMemberGroup;
        this.cardDeck = cardDeck;
    }

    public void pickStartingCards() {
        gameMemberGroup.pickStartingCards(cardDeck);
        OutputView.showAllStartingCard(gameMemberGroup);
    }
}
