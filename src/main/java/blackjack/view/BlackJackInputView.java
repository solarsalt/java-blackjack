package blackjack.view;

import blackjack.util.TextParser;
import java.util.List;
import java.util.Scanner;

public class BlackJackInputView {
    private static final String INPUT_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String PLAYER_NAME_DELIMITER = ",";
    private static final String HIT_PROPOSAL = ", 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    public List<String> getPlayerNames() {
        showInputMessage(INPUT_PLAYER_NAME);
        return getInputNames();
    }

    private static void showInputMessage(String inputMessage) {
        System.out.println(inputMessage);
    }

    private static List<String> getInputNames() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return TextParser.split(line, PLAYER_NAME_DELIMITER);
    }

    public static String getInputHit(String name) {
        showInputMessage(name + HIT_PROPOSAL);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }
}
