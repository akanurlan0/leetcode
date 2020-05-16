import java.util.Scanner;

public class D {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in) ;
        int t = in.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = in.nextInt();

            int[] a = new int[n + 1];

            int k = 1;
            while (true) {

                int l = -1;
                int r = -1;

                int ll = -1;
                int rr = -1;
                for (int i = 1; i <= n; i++) {
                    if (a[i] == 0) {
                        if (ll == -1) {
                            ll = i;
                        }
                        rr = i;

                        if (l == -1 || (rr - ll > r - l)) {
                            l = ll;
                            r = rr;
                        }
                    } else {
                        ll = -1;
                        rr = -1;
                    }
                }
                if (l == -1) {
                    break;
                }

                int m = (r - l + 1) & 1;
                if (m == 1) {
                    a[(l+r) / 2] = k;
                } else {
                    a[(l+r-1) / 2] = k;
                }
                k++;
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        in.close();
    }
}
