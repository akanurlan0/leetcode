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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        
        traverse(root, 0);
        
        return root;
    }
    
    private int traverse(TreeNode node, int add) {
        
        int localAdd = add;
        if (node.right != null) {
            localAdd = traverse(node.right, add);
        }
        
        node.val += localAdd;
        localAdd = node.val;
        
        if (node.left != null) {
            localAdd = traverse(node.left, localAdd);
        }
        
        return localAdd;
    }
    
    
}