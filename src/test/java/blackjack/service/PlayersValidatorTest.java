package blackjack.service;

import static org.junit.jupiter.api.Assertions.*;

import blackjack.domain.Player;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayersValidatorTest {

    @Test
    @DisplayName("유효한 플레이어 수")
    void isValidPlayerNumber() {
        //given
        List<Player> minNumber = List.of("a", "b")
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        List<Player> maxNumber = List.of("a", "b", "c", "d", "e", "f", "g", "h")
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        //when
        assertTrue(PlayersValidator.isValidPlayerNumber(minNumber));
        assertTrue(PlayersValidator.isValidPlayerNumber(maxNumber));
    }

    @Test
    @DisplayName("유효하지 않은 플레이어 수")
    void isInValidPlayerNumber() {
        //given
        List<Player> minNumber = List.of("a")
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        List<Player> maxNumber = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i")
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        //when
        assertFalse(PlayersValidator.isValidPlayerNumber(minNumber));
        assertFalse(PlayersValidator.isValidPlayerNumber(maxNumber));
    }
}