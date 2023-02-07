package blackjack.view;

import blackjack.domain.Card;
import blackjack.domain.member.GameMember;
import blackjack.domain.member.GameMemberGroup;

public class OutputView {
    private static String INVALID_PLAYERS_ERROR = "게임 참여자는 2명이상 8명 이하여야 합니다. 다시 입력해주세요.";
    private static String SHOW_STARTING_CARD = "에게 2장을 나누었습니다.";

    public static void showInvalidPlayersError() {
        printText(INVALID_PLAYERS_ERROR);
    }

    public static void showCard(Card card) {
        printText(card.getCardInfo());
    }

    private static void printText(String text) {
        System.out.println(text);
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
        // todo
    }
}

