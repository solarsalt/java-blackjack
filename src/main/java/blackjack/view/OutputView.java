package blackjack.view;

import blackjack.domain.member.GameMember;
import blackjack.domain.member.GameMemberGroup;
import blackjack.domain.result.DealerResult;
import blackjack.domain.result.PlayerResult;
import blackjack.service.GameResultJudge;

public class OutputView {
    private static String INVALID_PLAYERS_ERROR = "게임 참여자는 2명이상 8명 이하여야 합니다. 다시 입력해주세요.";
    private static String SHOW_STARTING_CARD = "에게 2장을 나누었습니다.";
    private static String INVALID_HIT = "예는 y, 아니오는 n로만 응답하세요.";

    public static void showInvalidPlayersError() {
        printText(INVALID_PLAYERS_ERROR);
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

    public static void showTotalScore(GameMemberGroup gameMembers) {
        for (GameMember gameMember: gameMembers.toList()){
            printText(gameMember.getAllCardInfo()
                    + "- 결과: "
                    + gameMember.getCardBundle().calculateTotalScore());
        }
    }

    public static void showGameResult(GameResultJudge gameResultJudge) {
        PlayerResult playerResult = gameResultJudge.getPlayerResult();
        gameResultJudge.getDealerResult();
        gameResultJudge.getPlayerResult();
    }

    public static void showInvalidHitError() {
        printText(INVALID_HIT);
    }

    private static void printText(String text) {
        System.out.println(text);
    }


}

