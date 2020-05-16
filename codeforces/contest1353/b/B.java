import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in) ;
        int t = in.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }

            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int l = 0;
            int r = n - 1;
            for (int i = 0; i < k; i++) {
                if (a[l] < b[r]) {
                    int tmp = a[l];
                    a[l] = b[r];
                    b[r] = tmp;

                    l++;
                    r--;
                } else {
                    l++;
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                res += a[i];
            }

            System.out.println(res);
        }

        in.close();
    }
}
