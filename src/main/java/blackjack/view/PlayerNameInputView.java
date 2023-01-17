package blackjack.view;

import blackjack.util.TextParser;
import java.util.List;
import java.util.Scanner;

public class PlayerNameInputView {
    private static final String INPUT_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String PLAYER_NAME_DELIMITER = ",";

    public List<String> getPlayerNames() {
        showInputMessage();
        return getInputNames();
    }

    private static void showInputMessage() {
        System.out.println(INPUT_PLAYER_NAME);
    }

    private static List<String> getInputNames() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return TextParser.split(line, PLAYER_NAME_DELIMITER);
    }
}
