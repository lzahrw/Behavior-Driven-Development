package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int calculate(int value1, int value2, char opt) {
        switch (opt) {
            case '*':
                return value1 * value2;
            case '/':
                if (value2 == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return value1 / value2;
            case '^':
                int result = 1;
                for (int i = 0; i < value2; i++) {
                    result *= value1;
                }
                return result;
            default:
                throw new UnsupportedOperationException("Operation not implemented: " + opt);
        }
    }
}
