import model.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveCalculatorTest {
    public static final Logger LOG = LogManager.getLogger(PositiveCalculatorTest.class);

    @DataProvider
    public Object[][] positiveData() {
        LOG.info("DataProvider запущен");
        return new Object[][]{
                new String[]{"+", "2", "2", "4.0"},
                {"+", "а", "2", "4.0"},
                {"-", "3", "3", "0.0"},
                {"*", "3", "3", "9.0"},
                {"/", "3", "3", "1.0"}
        };
    }

    @Test(dataProvider = "positiveData")
    public static void positiveTest(String operator, String a, String b, String result) {
        LOG.info("Тест запущен");
        String[] params = {operator, a, b};
        Assert.assertEquals(Calculator.execute(params), result, "Несовпадение с ожидаемым значением");
    }
}
