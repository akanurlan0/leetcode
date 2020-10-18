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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    private boolean valid(TreeNode node, Integer leftRange, Integer rightRange) {
        
        if (node == null) return true;
        
        if ((leftRange != null && leftRange >= node.val) || (rightRange != null && node.val >= rightRange)) return false;
        
        return valid(node.left, leftRange, node.val)
            && valid(node.right, node.val, rightRange);
    }
}