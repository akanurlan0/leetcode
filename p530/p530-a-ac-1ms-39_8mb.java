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
    
    private List<Integer> list;
    
    public int getMinimumDifference(TreeNode root) {
        
        list = new ArrayList<Integer>();
        traverse(root);
        
        int res = list.get(1) - list.get(0);
        for (int i = 1; i < list.size() - 1; i++) {
            int l = list.get(i + 1) - list.get(i);
            if (l < res) {
                res = l;
            }
        }
        
        return res;
    }
    
    private void traverse(TreeNode node) {
        if (node.left != null) {
            traverse(node.left);
        }
        
        list.add(node.val);
        
        if (node.right != null) {
            traverse(node.right);
        }
    }
}
