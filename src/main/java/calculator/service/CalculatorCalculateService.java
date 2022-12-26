package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.model.NumericFormula;
import calculator.domain.model.Operator;

public class CalculatorCalculateService {
	private CalculatorCalculateService() {
	}
	
	private static class InstanceHolder {
		private static final CalculatorCalculateService INSTANCE = new CalculatorCalculateService();
	}
	
	public static CalculatorCalculateService getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	private final Calculator calculator = new Calculator();
	
	
	/**
	 * 수식에 맞는 연산을 수행한다.
	 *
	 * @param formula target 수식
	 * @return 최종 연산 값
	 */
	public int calculate(NumericFormula formula) {
		int[] numbers = formula.getNumbers();
		Operator[] operators = formula.getOperators();
		
		int x = numbers[0];
		for (int index = 0; index < operators.length; index++) {
			Operator operator = operators[index];
			int y = numbers[index + 1];
			
			x = operate(operator, x, y);
		}
		return x;
	}
	
	/**
	 * 연산자와 피연산자 두개를 받아 연산 값을 반환한다
	 *
	 * @param operator 연산자
	 * @param x        피연산자 1
	 * @param y        피연산자 2
	 * @return x 와 y를 연산한 값
	 */
	private int operate(Operator operator, int x, int y) {
		int result = 0;
		if (operator.isPlus()) {
			result = calculator.add(x, y);
		}
		if (operator.isMinus()) {
			result = calculator.subtract(x, y);
		}
		if (operator.isTimes()) {
			result = calculator.times(x, y);
		}
		if (operator.isDivision()) {
			result = calculator.divide(x, y);
		}
		return result;
	}
	
}
