class Solution {
    
    class data {
        int sum, pref, suff, ans;
    }

    private int[] a;
    private data[] t;

    public int maxSubarraySumCircular(int[] A) {

        int n = A.length;
        a = new int[n];

        data maxSoFar = null;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int k = (i + j) % n;
                a[j] = A[k];
            }

            t = new data[n * 4];

            build(1, 0, n - 1);

            data max = query(1, 0, n - 1, 0, n - 1);
            if (maxSoFar == null || max.ans > maxSoFar.ans) {
                maxSoFar = max;
            }
        }

        return maxSoFar.ans;
    }

    data query (int v, int tl, int tr, int l, int r) {
        if (l == tl && tr == r)
            return t[v];
        int tm = (tl + tr) / 2;
        if (r <= tm)
            return query (v*2, tl, tm, l, r);
        if (l > tm)
            return query (v*2+1, tm+1, tr, l, r);
        return combine (
                query (v*2, tl, tm, l, tm),
                query (v*2+1, tm+1, tr, tm+1, r)
        );
    }

    void build(int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = makeData(a[tl]);
        } else {
            int tm = (tl + tr) / 2;
            build(v * 2, tl, tm);
            build(v * 2 + 1, tm + 1, tr);
            t[v] = combine(t[v * 2], t[v * 2 + 1]);
        }
    }

    data makeData(int val) {
        data res = new data();
        res.sum = val;
        res.pref = res.suff = res.ans = val;
        return res;
    }

    data combine(data l, data r) {
        data res = new data();
        res.sum = l.sum + r.sum;
        res.pref = Math.max(l.pref, l.sum + r.pref);
        res.suff = Math.max(r.suff, r.sum + l.suff);
        res.ans = Math.max( Math.max(l.ans, r.ans), l.suff + r.pref );
        return res;
    }
}