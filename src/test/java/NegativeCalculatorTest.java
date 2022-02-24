import model.Calculator;
import model.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeCalculatorTest {
    @DataProvider
    public Object[][] negativeData() {
        return new Object[][]{
                {"+", 2, 2},
                {"-", 3, 3},
                {"*", 3, 3},
                {"/", 3, 0}
        };
    }

    @Test(dataProvider = "negativeData")
    public static void negativeTest(String operator, String a, String b) {
        String[] params = {operator, a, b};
        try {
            Assert.fail(Calculator.execute(params));
        } catch (CalculatorException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}
