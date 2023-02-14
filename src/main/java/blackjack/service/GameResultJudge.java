package blackjack.service;

import blackjack.domain.member.GameMemberGroup;
import blackjack.domain.result.DealerResult;
import blackjack.domain.result.PlayerResult;

public class GameResultJudge {
    GameMemberGroup gameMemberGroup;

    public GameResultJudge(GameMemberGroup gameMemberGroup) {
        this.gameMemberGroup = gameMemberGroup;
    }

    public PlayerResult getPlayerResult() {
        // 각 플레이어의 점수와 딜러를 점수를 비교해서 플레이어 vs 딜러 승패 결정
        // 플레이어 중 1명이라도 점수가 21을 초과하면, 플레이어 패 => 버스트, 패인데 특별한 패
        // 버스트 상황에서 딜러가 21초과해도, 플레이어가 패배한다.
        return new PlayerResult();
    }

    public DealerResult getDealerResult() {
        return new DealerResult();
    }
}
