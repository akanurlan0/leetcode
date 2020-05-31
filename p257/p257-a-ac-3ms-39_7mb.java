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
    
    private List<String> stack;
    private List<String> res;
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        this.res = new ArrayList<String>();
        this.stack = new ArrayList<String>();
        
        if (root != null) {
            traverse(root);
        }
        
        return this.res;
    }
    
    private void traverse(TreeNode node) {
        
        stack.add(String.valueOf(node.val));
        
        if (node.left == node.right && node.right == null) {
            res.add(String.join("->", stack));
        } else {
            if (node.left != null) {
                traverse(node.left);
            }
            if (node.right != null) {
                traverse(node.right);
            }
        }
        
        stack.remove(stack.size()-1);
    }
}