package blackjack;

import blackjack.domain.member.Dealer;
import blackjack.domain.member.Players;
import blackjack.service.BlackJackGame;
import blackjack.service.GamePlayersMaker;

public class BlackJackApplication {
    public static void main(String[] args) {
        Players players = new GamePlayersMaker().createPlayers();
        Dealer dealer = new GamePlayersMaker().createDealer();
        BlackJackGame blackJackGame = new BlackJackGame(players, dealer);
        blackJackGame.play();
    }
}