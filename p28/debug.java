class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int n = a.length;
        int m = b.length;
        
        if (m == 0) return 0;
        
        int[] map = new int[m];
        
        int i = 0;
        int j = 0;
        map[0] = -1;
        for (j = 1; j < m; j++) {
            if (b[i] == b[j]) {
                map[j] = map[j - 1] + 1;
                i++;
            } else {
                i = 0;
            }
        }
        
        i = 0;
        j = 0;
        
        while (i < n) {
            if (a[i] == b[j]) {
                i++;
                j++;
                if (j == m) {
                    return i - j;
                }
            } else {
                j = map[j];
                if (j < 0) {
                    i++;
                    j++;
                }
            }
        }
        
        return -1;
    }
}