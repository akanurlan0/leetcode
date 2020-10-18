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
    
    private int count = 0;
    
    public int countNodes(TreeNode root) {
        count = 0;
        traverse(root);
        return count;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) return;
        
        this.count++;
        traverse(node.left);
        traverse(node.right);
    }
}