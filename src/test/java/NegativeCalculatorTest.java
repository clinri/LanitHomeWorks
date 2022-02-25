import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData() {
        return new Object[][]{
                {"/", "3", "0"}
        };
    }

    @Test(dataProvider = "negativeData")
    public static void negativeTest(String operator, String a, String b) {
        String[] params = {operator, a, b};
        Assert.assertEquals(Calculator.execute(params),
                String.valueOf(Double.POSITIVE_INFINITY),"Несовпадение с ожидаемым значением");
    }
}
