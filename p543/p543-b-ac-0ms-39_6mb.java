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
        
        traverse(root, 0);
        
        return res;
    }
    
    private int traverse(TreeNode node, int level) {
        
        int left = 0;
        
        if (node.left != null) {
            left = traverse(node.left, level+1);
        }
        
        int right = 0;
        if (node.right != null) {
            right = traverse(node.right, level+1);
        }
        
        if (left + right == 0) {
            return level;
        }
        
        if (left + right - (2 * level) > res) {
            res = left + right - (2 * level);
        }
        
        return left > right ? left : right;
    }
    
    
}