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
    
    private int res;
    
    public int sumNumbers(TreeNode root) {
        res = 0;
        traverse(root, 0);
        return res;
    }
    
    private void traverse(TreeNode node, int path) {
        
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            res += (path * 10) + node.val;
            return;
        }
        
        traverse(node.left,  (path * 10) + node.val);
        traverse(node.right, (path * 10) + node.val);
    }
}