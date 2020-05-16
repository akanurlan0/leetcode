import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in) ;
        int t = in.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int n = in.nextInt();

            int[] a = new int[n+1];

            PriorityQueue<Range> pq = new PriorityQueue<>((o1, o2) -> {

                int len1 = o1.getLen();
                int len2 = o2.getLen();

                if (len1 > len2) {
                    return -1;
                }
                if (len1 < len2) {
                    return 1;
                }
                if (o1.l < o2.l) {
                    return -1;
                }
                if (o1.l > o2.l) {
                    return 1;
                }
                return 0;
            });

            pq.add(new Range(1, n));

            int k = 1;

            while (pq.size() > 0) {
                Range range = pq.poll();

                int l = range.l;
                int r = range.r;

                int mid;

                int odd = (r - l + 1) & 1;
                if (odd == 1) {
                    mid = (l+r) / 2;
                    a[mid] = k;
                } else {
                    mid = (l+r-1) / 2;
                    a[mid] = k;
                }
                k++;

                if (mid - 1 >= l) {
                    pq.add(new Range(l, mid - 1));
                }
                if (mid + 1 <= r) {
                    pq.add(new Range(mid + 1, r));
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }

        in.close();
    }

    static class Range {
        public final int l, r;
        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }

        int getLen() {
            return r - l;
        }
    }

//    TL
//    public static void main(String[] args)  {
//        Scanner in = new Scanner(System.in) ;
//        int t = in.nextInt();
//
//        for (int tc = 0; tc < t; tc++) {
//            int n = in.nextInt();
//
//            int[] a = new int[n + 1];
//
//            int k = 1;
//            while (true) {
//
//                int l = -1;
//                int r = -1;
//
//                int ll = -1;
//                int rr = -1;
//                for (int i = 1; i <= n; i++) {
//                    if (a[i] == 0) {
//                        if (ll == -1) {
//                            ll = i;
//                        }
//                        rr = i;
//
//                        if (l == -1 || (rr - ll > r - l)) {
//                            l = ll;
//                            r = rr;
//                        }
//                    } else {
//                        ll = -1;
//                        rr = -1;
//                    }
//                }
//                if (l == -1) {
//                    break;
//                }
//
//                int m = (r - l + 1) & 1;
//                if (m == 1) {
//                    a[(l+r) / 2] = k;
//                } else {
//                    a[(l+r-1) / 2] = k;
//                }
//                k++;
//            }
//
//            for (int i = 1; i <= n; i++) {
//                System.out.print(a[i] + " ");
//            }
//            System.out.println();
//        }
//
//        in.close();
//    }
}
