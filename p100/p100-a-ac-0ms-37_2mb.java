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
    
    private boolean res;
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        res = true;
        traverse(p, q);
        
        return res;
    }
    
    private void traverse(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) {
            return;
        }
        if ((p == null) != (q == null)) {
            res = false;
            return;
        }
        
        traverse(p.left, q.left);
        
        if (res == false) return;
        
        if (p.val != q.val) {
            res = false;
            return;
        }
        
        traverse(p.right, q.right);
    }
}