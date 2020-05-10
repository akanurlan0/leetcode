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

    private TreeNode prev = null;
    private int res = Integer.MAX_VALUE;;
    
    public int getMinimumDifference(TreeNode root) {

        prev = null;
        res = Integer.MAX_VALUE;
        
        traverse(root);
        
        return res;
    }
    
    private void traverse(TreeNode node) {
        
        if (node.left != null) {
            traverse(node.left);
        }
        
        if (prev != null) {
            int v = node.val - prev.val;
            if (res > v) {
                res = v;
            }
        }
        
        prev = node;
        
        if (node.right != null) {
            traverse(node.right);
        }
    }
}
