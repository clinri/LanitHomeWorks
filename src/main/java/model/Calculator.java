package model;

public class Calculator {
    public static String execute(String[] params){
        String a = params[1];
        String b = params[2];
        switch ((params[0]).charAt(0)){
            case '+':
                return add(a,b);
            case '-':
                return sub(a,b);
            case '*':
                return multi(a,b);
            case '/':
                return div(a,b);
        }
        return "";
    }

    private static String add(String a, String b){
//        return a + b;
        return "";
    }
    private static String sub(String a, String b){
//        return a - b;
        return "";
    }
    private static String multi(String a, String b){
//        return a - b;
        return "";
    }
    private static String div(String a, String b){
//        return a - b;
        return "";
    }
}


