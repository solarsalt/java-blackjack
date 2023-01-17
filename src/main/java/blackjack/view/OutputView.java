package blackjack.view;

public class OutputView {
    private static String INVALID_PLAYERS_ERROR = "게임 참여자는 2명이상 8명 이하여야 합니다. 다시 입력해주세요.";

    public static void showInvalidPlayersError() {
        System.out.println(INVALID_PLAYERS_ERROR);
    }
}
