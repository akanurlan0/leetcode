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
    
    int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        res = 0;
        
        depth(root);
        
        return res;
    }
    
    private int depth(TreeNode node) {
        
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        
        int currDiameter = leftDepth + rightDepth;
        
        if (res < currDiameter) {
            res = currDiameter;
        }
        
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    
}