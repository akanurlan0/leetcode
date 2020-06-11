class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        
        int n = A.length;
        
        int[] arr = new int[n + 5];
        
        for (int i = 0; i < n; i++) {
            arr[i] = A[n - i - 1];
        }
        
        int i = 0;
        int add = 0;
        int newSize = n;
        while (K > 0 || add > 0 || i < n) {
            int r = K % 10;
            K = K / 10;
            arr[i] += r + add;
            if (arr[i] > 9) {
                add = 1;
                arr[i] = arr[i] % 10;
            } else {
                add = 0;
            }
            i++;
            if (i > n) {
                newSize = i;
            }
        }
        
        n = newSize;

        List<Integer> res = new ArrayList<Integer>(n);
        for (i = n - 1; i >= 0; i--) {
            res.add(arr[i]);
        }
        
        return res;
    }
    
    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}