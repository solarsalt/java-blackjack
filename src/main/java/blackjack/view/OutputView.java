package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.member.GameMember;
import blackjack.domain.member.GameMemberGroup;

public class OutputView {
    private static String INVALID_PLAYERS_ERROR = "게임 참여자는 2명이상 8명 이하여야 합니다. 다시 입력해주세요.";
    private static String SHOW_STARTING_CARD = "에게 2장을 나누었습니다.";
    private static String INVALID_HIT = "예는 y, 아니오는 n로만 응답하세요.";

    public static void showInvalidPlayersError() {
        printText(INVALID_PLAYERS_ERROR);
    }

    public static void showCard(Card card) {
        printText(card.getCardInfo());
    }

    public static void showAllStartingCard(GameMemberGroup gameMembers) {
        showGameMemberNames(gameMembers);
        for (GameMember gameMember : gameMembers.toList()) {
            printText(gameMember.getStartingCardInfo());
        }
    }

    private static void showGameMemberNames(GameMemberGroup gameMembers) {
        String names = gameMembers.getGameMemberNames();
        printText(names + SHOW_STARTING_CARD);
    }

    public static void showGameResult(GameMemberGroup gameMembers) {
        for (GameMember gameMember: gameMembers.toList()){
            printText(gameMember.getAllCardInfo()
                    + "- 결과: "
                    + gameMember.getCardBundle().calculateTotalScore());
        }
        printText("## 최종승패");
        //todo 승패 결과 노출
//        딜러: 1승 1패
//        pobi: 승
//        jason: 패
    }

    public static void showInvalidHitError() {
        printText(INVALID_HIT);
    }

    private static void printText(String text) {
        System.out.println(text);
    }


}

