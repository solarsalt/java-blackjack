package blackjack.domain.member;

import blackjack.domain.card.CardBundle;
import blackjack.domain.card.CardDeck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameMemberGroup {
    private List<GameMember> gameMembers;

    public GameMemberGroup(Players players, Dealer dealer) {
        this.gameMembers = new ArrayList<>(players.toList());
        this.gameMembers.add(dealer);
    }

    public void pickStartingCards(CardDeck cardDeck) {
        gameMembers.forEach(gameMember -> {
            CardBundle picked = cardDeck.pickStartingCardBundle();
            gameMember.pickStartingCards(picked);
        });
    }

    public String getGameMemberNames() {
        return gameMembers.stream()
                .map(GameMember::getName)
                .collect(Collectors.joining(", "));
    }

    public List<GameMember> toList() {
        return gameMembers;
    }

    public void recordScores() {
        for (GameMember gameMember : gameMembers) {
            int totalScore = gameMember.getCardBundle().calculateTotalScore();
            gameMember.recordScore(totalScore);
        }
    }
}
