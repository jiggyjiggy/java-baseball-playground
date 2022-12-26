package calculator.domain.model;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumericFormula {
    private static final String INVALID_FORMULA = "수식 입력 형식이 틀렸습니다.";
    private final String[] formula;

    public NumericFormula(String[] formula) {
        validate(formula);
        this.formula = formula;
    }

    private void validate(String[] formula) {
        checkNumbersInEvenIndex(formula);
        checkOperatorsInOddIndex(formula);
        checkNumberInStartAndEnd(formula);
    }

    private void checkNumbersInEvenIndex(String[] formula) {
        Object[] elements = extractEvenIndexElements(formula);
        if (!isInts(elements)) {
            throw new IllegalArgumentException(INVALID_FORMULA);
        }
    }

    private void checkOperatorsInOddIndex(String[] formula) {
        Object[] elements = extractOddIndexElements(formula);
        if (!isOperators(elements)) {
            throw new IllegalArgumentException(INVALID_FORMULA);
        }
    }

    private void checkNumberInStartAndEnd(String[] formula) {
        String startElement = formula[0];
        String endElement = formula[formula.length - 1];
        if (!(isInt(startElement) && isInt(endElement))) {
            throw new IllegalArgumentException(INVALID_FORMULA);
        }
    }

    private boolean isInt(Object element) {
        try {
            if (element instanceof String) {
                Integer.parseInt((String) element);
                return true;
            }
            if (element instanceof Integer) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    private boolean isInts(Object[] elements) {
        return Arrays.stream(elements)
                .allMatch(this::isInt);
    }

    private boolean isOperators(Object[] elements) {
        return Arrays.stream(elements)
                .allMatch(element -> {
                    if (element instanceof String) {
                        Operator.parseOperator((String) element);
                        return true;
                    }
                    return false;
                });
    }

    public Object[] extractEvenIndexElements(String[] formula) {
        return IntStream.range(0, formula.length)
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> formula[index])
                .toArray();
    }

    public Object[] extractOddIndexElements(String[] formula) {
        return IntStream.range(0, formula.length)
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> formula[index])
                .toArray();
    }

    public int[] getNumbers() {
        return IntStream.range(0, formula.length)
                .filter(index -> index % 2 == 0)
                .mapToObj(index -> formula[index])
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public Operator[] getOperators() {
        return IntStream.range(0, formula.length)
                .filter(index -> index % 2 != 0)
                .mapToObj(index -> formula[index])
                .map(Operator::parseOperator)
                .toArray(Operator[]::new);
    }

}
