package lotto.asis;

import lotto.asis.LottoRank;

import java.util.Map;

@FunctionalInterface
public interface MarginOperation {
    long multiply(Map<LottoRank, Integer> map);


}
