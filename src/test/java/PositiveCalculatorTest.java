import model.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalculatorTest {

    @DataProvider
    public Object[][] positiveData() {
        String max = String.valueOf(Integer.MAX_VALUE);
        String maxMunusOne = String.valueOf(Integer.MAX_VALUE - 1);
        String min = String.valueOf(Integer.MIN_VALUE);
        String minPlusOne = String.valueOf(Integer.MIN_VALUE + 1);
        return new Object[][]{
                {"+", "2", "2", "4"},
                {"+", maxMunusOne, "1", max},
                {"-", "3", "3", "0"},
                {"-", minPlusOne, "1", min},
                {"*", "3", "3", "9"},
                {"/", "3", "3", "1"}
        };
    }

    @Test(dataProvider = "positiveData")
    public static void positiveTest(String operator, String a, String b, String result) {
        String[] params = {operator, a, b};
        Assert.assertEquals(Calculator.execute(params), result, "Несовпадение с ожидаемым значением");
    }
}
