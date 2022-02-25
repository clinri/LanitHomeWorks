import model.Calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] paramsIn = new String[3];
        paramsIn[0] = in.nextLine();
        paramsIn[1] = in.nextLine();
        paramsIn[2] = in.nextLine();
        System.out.println(Calculator.execute(paramsIn));
    }
}