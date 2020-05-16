import java.util.Arrays;
import java.util.Scanner;

public class A {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in) ;
        int t = in.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = in.nextInt();
            int m = in.nextInt();

            if (n == 1) {
                System.out.println(0);
            } else
            if (n == 2) {
                System.out.println(m);
            } else {
                System.out.println(m * 2);
            }
        }

        in.close();
    }
}
