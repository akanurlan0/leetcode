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
    
    private int counter;
    private int k;
    private int res;
    
    public int kthSmallest(TreeNode root, int k) {
        
        this.counter = 0;
        this.k = k;
        this.res = -1;
        
        traverse(root);
        return res;
    }
    
    private void traverse(TreeNode node) {
        
        if (node.left != null) {
            traverse(node.left);
            if (counter == k) return;
        }
        
        counter++;
        if (counter == k) {
            res = node.val;
            return;
        }
        
        if (node.right != null) {
            traverse(node.right);
        }
    }
}