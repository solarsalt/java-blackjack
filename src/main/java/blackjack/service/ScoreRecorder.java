package blackjack.service;

import blackjack.domain.member.GameMemberGroup;

public class ScoreRecorder {
    private GameMemberGroup gameMemberGroup;

    public ScoreRecorder(GameMemberGroup gameMemberGroup){
        this.gameMemberGroup = gameMemberGroup;
    }

    public void record() {
        gameMemberGroup.recordScores();
    }
}
