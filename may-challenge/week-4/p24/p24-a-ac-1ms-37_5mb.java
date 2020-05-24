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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode prev = stack.peek();
            if (prev.val > val) {
                TreeNode left = new TreeNode(val);
                prev.left = left;
                stack.push(left);
                continue;
            }
            
            while (stack.isEmpty() == false && stack.peek().val < val) {
                prev = stack.pop();
            }
            TreeNode right = new TreeNode(val);
            prev.right = right;
            stack.push(right);
        }
        
        return root;
    }
}