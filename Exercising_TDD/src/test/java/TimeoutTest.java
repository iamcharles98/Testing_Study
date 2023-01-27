import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static java.lang.Thread.sleep;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TimeoutTest {
    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        // Calulator calulator = new Calulator();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void timeout_test() throws InterruptedException {

        verify(calculatorService,timeout(100)).add(20.0,10.0);
        when(calculatorService.add(20.0,10.0)).thenReturn(30.0);
        Assert.assertEquals(mathApplication.add(20.0,10.0),30.0,0);

    }

   /* private class Calulator implements CalculatorService {

        @Override
        public double add(double input1, double input2) throws InterruptedException {
            sleep(1000);
            return input1 + input2;
        }

        @Override
        public double subtract(double input1, double input2) {
            throw new UnsupportedOperationException("Nothing");
        }

        @Override
        public double multiply(double input1, double input2) {
            throw new UnsupportedOperationException("Nothing");
        }

        @Override
        public double divide(double input1, double input2) {
            throw new UnsupportedOperationException("Nothing");
        }
    }*/
}
