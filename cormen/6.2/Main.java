public class Main {

    public static void main(String[] args) {
//        System.out.println(2 << 1);

        int[] a = new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };

        heapsort(a);
    }

    public static void heapsort(
        int[] a     // array
    ) {
        debug(a, "initial");

        int n = a.length;
        buildMaxHeap(a, n);

        debug(a, "buildMaxHeap. heap size is " + n);

        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            n--;
            maxHeapify(a, 0, n);

            debug(a, "moved element at 0th position to " + i + " position. heap size is " + n + ". after maxHeapify");
        }

        debug(a, "sorted");
    }

    public static void buildMaxHeap(
        int[] a,    // array
        int n       // heap-size
    ) {
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(a, i, n);
        }
    }

    public static void maxHeapify(
        int[] a,    // array
        int i,      // index in array
        int n       // heap-size
    ) {
        int l = (i << 1) + 1;
        int r = (i << 1) + 2;

        int largest = i;
        if (l < n && a[l] > a[i]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, n);
        }
    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }

    public static void debug(int[] a, String message) {
        System.out.println(message);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("------------");
    }
}
