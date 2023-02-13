import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BDDexmaple {
    private MathApplication mathApplication;
    private CalculatorService calculatorService;

    @Before
    public void setup()
    {
        mathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }
    @Test
    public void BddStyleAddTest()  {
        //given
        given(calculatorService.add(20.0,10.0)).willReturn(30.0);

        //when
        double result = mathApplication.add(20.0, 10.0);

        //then
        Assert.assertEquals(result,30.0,0.0);

    }
}
