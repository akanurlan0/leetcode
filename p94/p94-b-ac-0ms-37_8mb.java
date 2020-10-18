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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        
        if (root != null) {
            stack.push(root);
        }
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            
            if (curr.left != null && !visited.contains(curr.left)) {
                stack.push(curr);
                stack.push(curr.left);
                continue;
            }
            
            if (!visited.contains(curr)) {
                list.add(curr.val);
                visited.add(curr);
            }
            
            if (curr.right != null && !visited.contains(curr.right)) {
                stack.push(curr);
                stack.push(curr.right);
                continue;
            }
            

        }
        
        return list;
    }
}