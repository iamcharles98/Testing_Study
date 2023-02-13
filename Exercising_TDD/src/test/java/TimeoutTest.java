import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;

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

    private final Runnable asyncOp = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                calculatorService.add(20.0, 10.0);
            } catch (InterruptedException e) {
            }
        }
    };
    @Test
    public void timeout_test() throws InterruptedException {

        when(calculatorService.add(20.0,10.0)).thenReturn(30.0);
       // new Thread(asyncOp).start();
        calculatorService.add(20.0,10.0);
        sleep(1000);
        verify(calculatorService,timeout(10)).add(20.0,10.0);
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
