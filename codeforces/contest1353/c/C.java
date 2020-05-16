import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        int[] cases = new int[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            cases[i] = n;
        }
        in.close();

        Arrays.sort(cases);

        int maxCases = cases[t - 1];

        int l = 0;

        int p = maxCases / 2;

        Long res = 0l;
        Long len = 1l;
        Long four = 4l;

        for (long i = 0l; i <= p; i++) {

            res += (i * len * four) - (i * four);
            if (cases[l] == len) {
                System.out.println(res);
                l++;
            }
            len += 2;
        }
    }
}
