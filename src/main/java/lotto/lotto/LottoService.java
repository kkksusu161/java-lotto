package lotto.lotto;

public class LottoService {

    private static final LottoMachine lottoMachine = LottoMachine.createInstance();

    public LottoMachine getLottoMachine(){
        return  lottoMachine;
    }

    public Lottos createLotto(String[] inputLottos, int autoCnt) {
        LottoParameters lottoParameters = new LottoParameters(inputLottos, autoCnt);

        Lottos autoLottos = lottoMachine.createLottos(new AutoLottoStrategy(), lottoParameters);
        Lottos manuaLottos = lottoMachine.createLottos(new ManualLottoStrategy(), lottoParameters);

        return new Lottos(autoLottos.getLottos(), manuaLottos.getLottos());
    }

    public int getAutoCount(int price, int manualCnt) {
        return lottoMachine.calculateAutoCnt(price, manualCnt);
    }

    public LottoResult calculateLottoRank(String answer, Lottos lottos, int bonusNumber) {
        LottoWinning winning = new LottoWinning(answer, bonusNumber);
        LottoResult result = new LottoResult();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = winning.matchCount(lotto);
            boolean isBonusMatch = lotto.containNumber(winning.getBonusNumber());
            LottoRank rank = LottoRank.findWinPrice(matchCount, isBonusMatch);
            result.updateResult(rank);
        }
        return result;
    }

    public LottoMargin calculateMarginRate(int price, LottoResult result) {
        return new LottoMargin(price, result.getResultMap());
    }
}
