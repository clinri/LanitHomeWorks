package model;

public class Calculator {
    private String max = String.valueOf(Integer.MAX_VALUE);
    private String min = String.valueOf(Integer.MIN_VALUE);
    private int a = 0;
    private int b = 0;
    private int result = 0;

    public String execute(String[] params) {
        String a = params[1];
        String b = params[2];
        switch (params[0]) {
            case "+":
                return add(a, b);
            case "-":
                return sub(a, b);
            case "*":
                return multi(a, b);
            case "/":
                return div(a, b);
            default:
                throw new CalculatorException("Неверный оператор");
        }
    }

    private String add(String aStr, String bStr) {
        int a = 0;
        int b = 0;
        int result;
        try {
            if (aStr.equals(max) || bStr.equals(max)) {
                throw new Exception();
            }
            a = Integer.parseInt(aStr);
            b = Integer.parseInt(bStr);
            result = a + b;
        } catch (Exception e) {
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private String sub(String aStr, String bStr) {
        int a = 0;
        int b = 0;
        int result;
        try {
            if (aStr.equals(min)) {
                throw new Exception();
            }
            a = Integer.parseInt(aStr);
            b = Integer.parseInt(bStr);
            result = a - b;
        } catch (Exception e) {
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private String multi(String aStr, String bStr) {
        int a = 0;
        int b = 0;
        int result;
        try {
            if (aStr.equals(max) || bStr.equals(max)) {
                throw new Exception();
            }
            a = Integer.parseInt(aStr);
            b = Integer.parseInt(bStr);
            result = a * b;
        } catch (Exception e) {
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private String div(String aStr, String bStr) {
        int a = 0;
        int b = 0;
        int result;
        try {
            if (aStr.equals(max) || bStr.equals(max)) {
                throw new Exception();
            }
            a = Integer.parseInt(aStr);
            b = Integer.parseInt(bStr);
            if (b == 0) {
                throw new Exception("Деление на 0");
            }
            result = a / b;
        } catch (Exception e) {
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }
}


