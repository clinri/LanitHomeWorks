import model.Calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] paramsIn = line.split(" ");
        System.out.println(paramsIn.length);
        String[] params = Arrays.copyOf(paramsIn, 3);
        for (int i = 0; i < 3; i++) {
            if (params[i] == null) {
                params[i] = "null";
            }
        }
        System.out.println(Calculator.execute(params));
    }
}