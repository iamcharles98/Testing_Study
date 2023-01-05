import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
   Triangle triangle = new Triangle(1,1,2);
    @Test
    public void checkInput() throws Exception// Input의 무결성을 체크하기 위함 //
    {
    Integer[] integers = new Integer[3];
    integers[0]=triangle.getA();
    integers[1]=triangle.getB();
    integers[2]=triangle.getC();
        for(int i : integers)
        {
            if(i<=0)throw new Exception("한 변으로 존재할 수 없는 값\n");
        }
    }
    @Test
    public void checkTriangle() throws Exception {
        Integer[] integers = new Integer[3];
        integers[0]=triangle.getA();
        integers[1]=triangle.getB();
        integers[2]=triangle.getC();
        Arrays.sort(integers);
        if(integers[0]+integers[1] <= integers[2])
            throw new Exception("삼각형 아님\n");
        else {
            if (integers[0] == integers[1] && integers[1] == integers[2])
            {
                System.out.println("정삼각형");
            }
            else if (integers[0] == integers[1] || integers[1] == integers[2])
            {
                System.out.println("이등변삼각형");
            }
            else
            {
                System.out.println("삼각형");
            }
        }
    }

}