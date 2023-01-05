import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleProgramTest {
     Scanner scanner = new Scanner(System.in);
   Integer[] integers = new Integer[3];
    @Test
    public void testTriangle() throws Exception
    {
        integers[0] = scanner.nextInt();
        integers[1]= scanner.nextInt();
        integers[2] = scanner.nextInt();
        Arrays.sort(integers);
        if(integers[0]+integers[1] < integers[2])
        {
            throw new Exception("삼각형 생성 불가\n");
        }
        else {
            if(integers[0]==integers[1] && integers[1]==integers[2])
            {
                System.out.println("정삼각형");
            } else if (integers[0]==integers[1] || integers[1]==integers[2]) {
                System.out.println("이등변삼각형");
            }
            else {
                System.out.println("삼각형");
            }
        }
    }

}
