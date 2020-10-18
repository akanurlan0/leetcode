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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return sym(root.left, root.right);
    }
    
    private boolean sym(TreeNode n1, TreeNode n2) {
        
        if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) return false;
        
        if (n1 == null && n2 == null) return true;
        
        if (n1.val != n2.val) return false;
        
        if (!sym(n1.left, n2.right)) return false;
        if (!sym(n1.right, n2.left)) return false;
        
        return true;
    }
}