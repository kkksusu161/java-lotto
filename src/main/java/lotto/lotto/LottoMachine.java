package lotto.lotto;

public class LottoMachine {

    private final static int MIN_PRICE = 1000;

    private LottoMachine() { //final int price, final int manualCnt) {
    }

    public static LottoMachine createInstance() {
        return new LottoMachine();
    }

    public Lottos createLottos(LottoGeneratorStrategy lottoGeneratorStrategy, LottoParameters lottoParameters) {
        return lottoGeneratorStrategy.generateLotto(lottoParameters);
    }

    public int calculateAutoCnt(int price, int manualCnt) {
        validatePrice(price);
        int autoCnt = price / MIN_PRICE - manualCnt;
        if (autoCnt < 0) {
            throw new IllegalArgumentException("금액을 초과하였습니다.");
        }
        return autoCnt;
    }

    private void validatePrice(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("1000원 이상입니다.");
        }
    }

}
