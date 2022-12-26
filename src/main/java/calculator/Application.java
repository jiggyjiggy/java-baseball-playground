package calculator;

import calculator.controller.CalculatorController;
import calculator.view.OutputView;

public class Application {
    private static final OutputView outputView = OutputView.getInstance();
    private static final CalculatorController calculatorController = CalculatorController.getInstance();
    
    public static void main(String[] args) {
        try {
            calculatorController.calculateNumericFormula();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
