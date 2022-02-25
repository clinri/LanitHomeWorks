package model;

public class Calculator {
    public static String execute(String[] params) {
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

    private static String add(String aStr, String bStr) {
        double a = 0;
        double b = 0;
        double result;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            result = a + b;
        } catch (Exception e) {
            result = 0;
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private static String sub(String aStr, String bStr) {
        double a = 0;
        double b = 0;
        double result;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            result = a - b;
        } catch (Exception e) {
            result = 0;
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private static String multi(String aStr, String bStr) {
        double a = 0;
        double b = 0;
        double result;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            result = a * b;
        } catch (Exception e) {
            result = 0;
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }

    private static String div(String aStr, String bStr) {
        double a = 0;
        double b = 0;
        double result;
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
            result = a / b;
        } catch (Exception e) {
            result = 0;
            throw new CalculatorException(e.getMessage());
        }
        return String.valueOf(result);
    }
}


