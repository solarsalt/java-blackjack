package blackjack.view;

import blackjack.domain.Card;

public class OutputView {
    private static String INVALID_PLAYERS_ERROR = "게임 참여자는 2명이상 8명 이하여야 합니다. 다시 입력해주세요.";

    public static void showInvalidPlayersError() {
        printText(INVALID_PLAYERS_ERROR);
    }

    public static void showCard(Card card) {
        printText(card.getCardInfo());
    }

    private static void printText(String text) {
        System.out.println(text);
    }
}

