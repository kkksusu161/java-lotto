package lotto.view;


import lotto.dto.LottoResultDTO;
import lotto.lotto.*;

import java.util.Map;

public class ResultView {

    public static void printResult(LottoResultDTO result) {
        System.out.println("당첨통계");
        System.out.println("============");
        Map<LottoRank, Integer> map = result.getResultMap();

        System.out.println("3개 일치 (5000원)- " + map.get(LottoRank.RANK_FOUR));
        System.out.println("4개 일치 (50000원)- " + map.get(LottoRank.RANK_THREE));
        System.out.println("5개 일치 (1500000원)- " + map.get(LottoRank.RANK_TWO));
        System.out.println("5개 일치 (30000000원)- " + map.get(LottoRank.RANK_TWO_BONUS));
        System.out.println("6개 일치 (2000000000원)- " + map.get(LottoRank.RANK_ONE));
        System.out.printf("총 수익률은 %.2f 입니다.", result.getMarginRate());
    }

    public void printCreateLotto(Lottos lottos) {
        System.out.println(lottos.getSize());
        for (int i = 0; i < lottos.getSize(); i++) {
            System.out.println(lottos.getLottos().get(i).toString());
        }
    }
}
