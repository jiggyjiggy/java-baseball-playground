package calculator.controller;

import calculator.domain.model.NumericFormula;
import calculator.service.CalculatorCalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private CalculatorController() {}
    private static class InstanceHolder {
        private static final CalculatorController INSTANCE = new CalculatorController();
    }
    public static CalculatorController getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static final OutputView outputView = OutputView.getInstance();
    
    private static final CalculatorCalculateService calculatorCalculateService = CalculatorCalculateService.getInstance();
    
    public void calculateNumericFormula() {
        NumericFormula formula = InputView.readNumericFormula();
        int result = calculatorCalculateService.calculate(formula);
        outputView.printResult(result);
    }
}

