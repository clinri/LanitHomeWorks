import model.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Calculator calculator = new Calculator();
        System.out.println(calculator.execute(line.split(" ")));
    }
}
