/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if (t1 == null && t2 == null) return null;
        
        TreeNode res;
        
        if (t1 != null && t2 != null) {
            res = t1;
            res.val = t1.val + t2.val;
        } else if (t1 != null) {
            res = t1;
        } else {
            res = t2;
        }
            
        res.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        res.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        
        return res;
    }
}