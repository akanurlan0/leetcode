/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        TreeNode node = root;
        set.add(node.val);
        
        while (node != p) {
            if (p.val > node.val) {
                node = node.right;
            } else
            if (p.val < node.val) {
                node = node.left;
            }
            set.add(node.val);
        }
        
        node = root;
        TreeNode lca = node;

        while (node != q) {
            if (q.val > node.val) {
                node = node.right;
            } else
            if (q.val < node.val) {
                node = node.left;
            }
            if (set.contains(node.val)) {
                lca = node;
            }
        }
        
        return lca;
    }
}