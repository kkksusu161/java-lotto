package lotto.view;


import lotto.dto.LottoResultDTO;
import lotto.lotto.LottoResult;

import java.util.Map;

public class ResultView {

    public static void printResult(LottoResultDTO result) {
        System.out.println("당첨통계");
        System.out.println("============");
        Map<Integer, Integer> map = result.getResultMap();

        System.out.println("3개 일치 (5000원)- " + map.get(3));
        System.out.println("4개 일치 (50000원)- " + map.get(4));
        System.out.println("5개 일치 (1500000원)- " + map.get(5));
        System.out.println("6개 일치 (2000000000원)- " + map.get(6));
        System.out.printf("총 수익률은 %.2f 입니다.", result.getMarginRate() );
    }

    public void printCreateLotto(LottoResult result) {
        System.out.println(result.getLottoSize() + "개를 구매했습니다.");

        for (int i = 0; i < result.getLottoSize(); i++) {
            System.out.println(result.getLotto(i).toString());
        }


    }
}