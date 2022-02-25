package model;

public class Calculator {
    private static final double MAX = Integer.MAX_VALUE;
    private static double MIN = Integer.MIN_VALUE;
    private static double a = 0;
    private static double b = 0;
    private static double result = 0;

    public static String execute(String[] params) {
        try {
            a = Double.parseDouble(params[1]);
            b = Double.parseDouble(params[2]);
        } catch (Exception e){
            throw new CalculatorException(e.getMessage());
        }
        switch (params[0]) {
            case "+":
                result = add(a, b);
                break;
            case "-":
                result = sub(a, b);
                break;
            case "*":
                result = multi(a, b);
                break;
            case "/":
                result = div(a, b);
                break;
            default:
                throw new CalculatorException("Неверный оператор");
        }
        if (result > MAX || result < MIN) {
            throw new CalculatorException("Вычисленное значение превышает максимальное значение");
        }
        return String.valueOf(result);
    }

    private static void stringToDouble(String aStr, String bStr) {
        // прием значений 0 и 0.0
        try {
            try {
                a = Double.parseDouble(aStr);
            } catch (Exception e) {
                a = Integer.parseInt(aStr);
            }
            try {
                b = Double.parseDouble(bStr);
            } catch (Exception e) {
                b = Integer.parseInt(bStr);
            }
        } catch (Exception e) {
            throw new CalculatorException(e.getMessage());
        }
    }

    private static double add(double a, double b) {
        return a + b;
    }

    private static double sub(double a, double b) {
        return a - b;
    }

    private static double multi(double a, double b) {
        return a * b;
    }

    private static double div(double a, double b) {
        if (b == 0) {
            throw new CalculatorException("Деление на 0");
        }
        return a / b;
    }
}