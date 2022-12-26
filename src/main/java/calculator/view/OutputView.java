package calculator.view;

public class OutputView {
    private OutputView() {}
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }
    public static OutputView getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    private static final String ERROR_MESSAGE = "[ERROR] %s";
    
    public void printResult(int result) {
        System.out.println(result);
    }

    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE, message);
    }
}
