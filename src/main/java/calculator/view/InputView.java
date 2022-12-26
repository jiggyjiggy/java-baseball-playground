package calculator.view;

import calculator.domain.model.NumericFormula;

import java.util.Scanner;

public class InputView {
	private InputView() {
	}
	
	private static class InstanceHolder {
		private static final InputView INSTANCE = new InputView();
	}
	
	public static InputView getInstance() {
		return InstanceHolder.INSTANCE;
	}
	
	/**
	 * 문자열을 입력받고 수식으로 반환한다
	 *
	 * @return 입력받은 문자열을 NumericFormula으로 반환한
	 */
	public static NumericFormula readNumericFormula() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().trim();
		String[] splitedInput = input.split("\\s");
		return new NumericFormula(splitedInput);
	}
}
