import java.util.Comparator;

class P975Solution {

    public static void main(String[] args) {
        int[] in = new int[] {1,2,3,2,1,4,4,5};
        System.out.println(
            new P975Solution().oddEvenJumps(in)
        );
    }

    class Key {
        int val;
        int index;

        public Key(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public String toString() {
            return "{ val: " + val + " , index: " + index + " }";
        }
    }

    static Comparator<Key> directOrder = (o1, o2) -> {
        int diff =  o1.val - o2.val;
        if (diff != 0) return diff;
        return o1.index - o2.index;
    };

    static Comparator<Key> indirectOrder = (o1, o2) -> {
        int diff =  o1.val - o2.val;
        if (diff != 0) return diff;
        return o2.index - o1.index;
    };

    class BST {

        TreeNode root;
        Comparator<Key> comparator;

        class TreeNode {

            Key key;
            TreeNode p;
            TreeNode left;
            TreeNode right;

            public TreeNode(Key key) { this.key = key; }
        }

        public BST(Comparator<Key> comparator) {
            this.comparator = comparator;
        }

        void insert(Key k) { // 14

            TreeNode node = new TreeNode(k);

            TreeNode x = root; // 15
            TreeNode y = null; // null

            while (x != null) {
                y = x; // y = 13
                if (comparator.compare(x.key, node.key) > 0) {
                    x = x.left;
                } else {
                    x = x.right; // x = null
                }
            }

            if (y == null) {
                root = node;
            } else {
                if (comparator.compare(y.key, node.key) > 0) {
                    y.left = node;
                } else {
                    y.right = node;
                }
                node.p = y;
            }
        }

        Key min(TreeNode x) {
            while (x.left != null) {
                x = x.left;
            }
            return x.key;
        }

        Key max(TreeNode x) {
            while (x.right != null) {
                x = x.right;
            }
            return x.key;
        }

        TreeNode search(Key k) {

            TreeNode x = root;

            while (x != null && comparator.compare(x.key, k) != 0) {
                x = comparator.compare(x.key, k) > 0 ? x.left : x.right;
            }

            return x;
        }

        Key successor(Key k) {

            TreeNode x = search(k);

            if (x.right != null) return min(x.right);

            TreeNode y = x.p;
            while (x != null && y != null && y.right == x) {
                x = y;
                y = y.p;
            }
            return y == null ? null : y.key;
        }

        Key predecessor(Key k) {
            TreeNode x = search(k);

            if (x.left != null) return max(x.left);

            TreeNode y = x.p;
            while (x != null && y != null && y.left == x) {
                x = y;
                y = y.p;
            }
            while (y != null && y.left != null && y.key.val == y.left.key.val) {
                y = y.left;
            }
            return y == null ? null : y.key;
        }
    }

    public int oddEvenJumps(int[] a) {
        
        int n = a.length;
        
        int[] o = new int[n];
        int[] e = new int[n];

        for (int i = 0; i < n; i++) o[i] = 1;

        int[] mo = new int[n];
        int[] me = new int[n];
        BST bst1 = new BST(directOrder);
        BST bst2 = new BST(indirectOrder);

        for (int i = n - 1; i >= 0; i--) {
            Key key = new Key(a[i], i);
            bst1.insert(key);
            Key successor = bst1.successor(key);
            mo[i] = successor == null ? -1 : successor.index;

            bst2.insert(key);
            Key predecessor = bst2.predecessor(key);
            me[i] = predecessor == null ? -1 : predecessor.index;
        }
        
        for (int i = 0; i < n; i++) {
            
            {
                int ind = mo[i];

                if (ind != -1) {
                    e[ind] += o[i];
                }
            }
            
            if (e[i] > 0) {

                int ind = me[i];

                if (ind != -1) {
                    o[ind] += e[i];
                }
            }
        }
        
        return o[n - 1] + e[n - 1];
    }
}