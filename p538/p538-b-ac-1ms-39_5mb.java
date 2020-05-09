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
        
        List<TreeNode> list = new ArrayList<TreeNode>();
        traverse(root, list);
        
        int s = 0;
        
        for (int i = 0; i < list.size(); i++) {
            TreeNode curr = list.get(i);
            
            s += curr.val;
            curr.val = s;
        }
        
        return root;
    }
    
    private void traverse(TreeNode node, List<TreeNode> list) {
        if (node.right != null) {
            traverse(node.right, list);
        }
        
        list.add(node);
        
        if (node.left != null) {
            traverse(node.left, list);
        }
    }
    
    
}