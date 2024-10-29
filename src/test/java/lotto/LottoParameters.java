package lotto;

public class LottoParameters {
    private String[] manualLottos;
    private int autoCount;

    public LottoParameters(String[] manualLottos, int autoCount) {
        this.manualLottos = manualLottos;
        this.autoCount = autoCount;
    }

    public String[] getManualLottos() {
        return manualLottos;
    }

    public int getAutoCount() {
        return autoCount;
    }
}
