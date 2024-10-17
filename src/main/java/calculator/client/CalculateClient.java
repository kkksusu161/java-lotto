package calculator.client;

import calculator.controller.CalculateController;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculateClient {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        CalculateController calculateController = new CalculateController(inputView, resultView);
        calculateController.startCalculate();

    }
}
