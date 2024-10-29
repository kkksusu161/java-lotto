package lotto.controller;

import lotto.lotto.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLotto() {
        int price = inputView.inputPrice();
        int manualCnt = inputView.inputManualCnt();
        String[] inputManualLotto = inputView.inputManualLotto(manualCnt);

        LottoService lottoService = new LottoService();

        //LottoMachine lottoMachine = lottoService.createLottoMachine();
        int autoCnt = lottoService.getAutoCount(price, manualCnt);
        Lottos lottos = lottoService.createLotto(inputManualLotto, autoCnt);

        resultView.printLottoCnt(autoCnt, manualCnt);
        resultView.printCreateLotto(lottos);

        String answer = inputView.inputAnswer();
        int bonusNumber = inputView.inputBonus();

        LottoResult result = lottoService.calculateLottoRank(answer, lottos, bonusNumber);
        LottoMargin lottoMargin = lottoService.calculateMarginRate(price, result);

        resultView.printResult(LottoResult.from(result, lottoMargin));
    }
}
