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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<TreeNode> seq1 = new ArrayList<>();
        List<TreeNode> seq2 = new ArrayList<>();
        
        constructLeafValueSequence(root1, seq1);
        constructLeafValueSequence(root2, seq2);
        
        if (seq1.size() != seq2.size()) {
            return false;
        }
        
        boolean res = true;
        
        for (int i = 0; i < seq1.size(); i++) {
            if (seq1.get(i).val != seq2.get(i).val) {
                res = false;
                break;
            }
        }
        
        return res;
    }
    
    private void constructLeafValueSequence(TreeNode node, List<TreeNode> leafValueSeq) {
        if (node.left != null) {
            constructLeafValueSequence(node.left, leafValueSeq);
        }
        if (node.right != null) {
            constructLeafValueSequence(node.right, leafValueSeq);
        }
        
        if (node.left == null && node.right == null) {
            leafValueSeq.add(node);
        }
    }
}