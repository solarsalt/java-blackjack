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

    public void pickStartingCards(CardDeck cardDeck){
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

    //todo
    public String getGameResult() {
        //todo
        // 딜러 추출, 딜러 점수
        // 각 플레이어에게 딜러 점수 전달, 승패 결과 가져오기
        // 플레이어 승,패 저장 후 딜러 승패결과로 활용
        return "딜러 : 1승 1패, 플레이어1: 승, 플레이어 2: 패";
    }
}
