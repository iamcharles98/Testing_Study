import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTestV2 {
    MathApplication mathApplication;
    CalculatorService calculatorService;
    @Before
    public void setUp()
    {
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calculatorService = (CalculatorService) spy(calculator);
        mathApplication.setCalculatorService(calculatorService);
    }
    @Test
    public void TestAdd()
    {
        Assert.assertEquals(mathApplication.add(20.0,10.0),30.0,0);
    }
    private class Calculator implements CalculatorService {
        @Override
        public double add(double input1, double input2) {
            return input1+input2;
        }
        @Override
        public double subtract(double input1, double input2) {
            throw new UnsupportedOperationException("Not Implemeted!!");
        }
        @Override
        public double multiply(double input1, double input2) {
            throw new UnsupportedOperationException("Not Implemeted!!");
        }
        @Override
        public double divide(double input1, double input2) {
            throw new UnsupportedOperationException("Not Implemeted!!");
        }
    }
}
