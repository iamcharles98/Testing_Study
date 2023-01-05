import java.util.Arrays;
import java.util.Scanner;

public class Triangle_Program {

    public static void main(String[] args) throws Exception {
        Scanner scanner =new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        testTriangle(a,b,c);
    }
        public static void testTriangle(int a, int b, int c)throws Exception {
            if(a<=0 || b <=0 || c<= 0) throw new Exception("0 또는 음수 값 입력 불가!!\n");
            Integer[] integers = new Integer[3];
            integers[0] = a;
            integers[1] = b;
            integers[2] = c;
            Arrays.sort(integers);
            if (integers[0] + integers[1] < integers[2])
            {
                throw new Exception("삼각형 생성 불가\n");
            } else
            {
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



