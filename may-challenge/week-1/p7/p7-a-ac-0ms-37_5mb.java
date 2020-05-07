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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        TreeNode[] queue = new TreeNode[101];
        int l = 0;
        int r = 0;
        queue[r++] = root;
        
        int[] depthMap = new int[101];
        depthMap[root.val] = 0;
        
        TreeNode[] parentMap = new TreeNode[101];
        parentMap[root.val] = null;
        
        while (l < r) {
            
            TreeNode curr = queue[l];
            
            if (curr.left != null) {
                
                queue[r] = curr.left;
                depthMap[curr.left.val] = depthMap[curr.val] + 1;
                parentMap[curr.left.val] = curr;
                r++;
            }
            
            if (curr.right != null) {
                queue[r] = curr.right;
                depthMap[curr.right.val] = depthMap[curr.val] + 1;
                parentMap[curr.right.val] = curr;
                r++;
            }
            
            l++;
        }

        return (depthMap[x] == depthMap[y] && parentMap[x] != parentMap[y]);
    }
}