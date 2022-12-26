package calculator.domain.model;

import java.util.regex.Pattern;

public class Operator {
	private static final String INVALID_OPERATOR = "지원하지 않는 연산자입니다.";
	
	private final String operator;
	
	public String getOperator() {
		return operator;
	}
	
	public Operator(String operator) {
		validate(operator);
		this.operator = operator;
	}
	
	/**
	 * 입력받은 연산자가 사칙연산 연산자인지 유효성을 검증한다.
	 *
	 * @param operator
	 */
	private void validate(String operator) {
		if (!(Pattern.matches("[+\\-*/]", operator))) {
			throw new IllegalArgumentException(INVALID_OPERATOR);
		}
	}
	
	public static Operator parseOperator(String operator) {
		return new Operator(operator);
	}
	
	public boolean isPlus() {
		return this.getOperator().equals("+");
	}
	public boolean isMinus() {
		return this.getOperator().equals("-");
	}
	public boolean isTimes() {
		return this.getOperator().equals("*");
	}
	public boolean isDivision() {
		return this.getOperator().equals("/");
	}
}