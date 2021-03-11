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
    public TreeNode bstToGst(TreeNode root) {
        
        convert(root, null);
        return root;
    }
    
    private void convert(TreeNode node, TreeNode p) {
        
        if (node == null) return;
        
        convert(node.right, p);
        
        if (node.right != null) {
            TreeNode x = node.right;
            TreeNode y = null;
            while (x != null) {
                y = x;
                x = x.left;
            }
            node.val += y.val;
        } else if (p != null) {
            node.val += p.val;
        }
        
        convert(node.left, node);
    }
}