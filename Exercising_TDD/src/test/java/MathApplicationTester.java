/*import Exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;



    @Test
    public void add_Test()
    {

        when(calculatorService.add(10.0,10.0)).thenReturn(20.0);
        Assert.assertEquals(mathApplication.add(10.0,10.0),20.0,1.0);
        verify(calculatorService).add(10.0,10.0);
    }
    @Test
    public void subtract_Test()
    {

        when(calculatorService.subtract(10.0,10.0)).thenReturn(0.0);
        Assert.assertEquals(mathApplication.subtract(10.0,10.0),0.0,0.0);
        verify(calculatorService).subtract(20.0,10.0);
    }
    @Test
    public void multiply_Test()
    {
        when(calculatorService.multiply(10.0,10.0)).thenReturn(100.0);
        Assert.assertEquals(mathApplication.multiply(10.0,10.0),100.0,0.0);
    }
    @Test
    public void divide_Test()
    {
        when(calculatorService.divide(10.0,10.0)).thenReturn(1.0);
        Assert.assertEquals(mathApplication.divide(10.0,10.0),1.0,0.0);
    }

    @Test(expected = RuntimeException.class)
    public void ThrowException_Test()
    {
        doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService).add(10.0,20.0);
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
    }


}
*/