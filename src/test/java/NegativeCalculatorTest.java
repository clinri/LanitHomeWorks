import model.Calculator;
import model.CalculatorException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData() {
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        System.out.println(max);
        return new Object[][]{
                {"/", "3", "0"},
                {"+", max, "1.0"},
                {"-", max, "-1"},
                {"-", min, "1"},
                {"+", min, "-1"},
                {"?", min, "1"},
                {"+", "one", "two"},
                {"+", null, null}
        };
    }

    @Test(dataProvider = "negativeData", expectedExceptions = {CalculatorException.class})
    public static void negativeTest(String operator, String a, String b) {
        String[] params = {operator, a, b};
        System.out.println(Calculator.execute(params));
    }
}