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
         
        List<TreeNode> q = new ArrayList<TreeNode>();
        int l = 0;
        if (root != null) {
            q.add(root);
        }

        while (l < q.size()) {
            
            TreeNode curr = q.get(l);

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            
            l++;
        }
        
        Collections.sort(q, new Comparator<TreeNode>(){
             public int compare(TreeNode o1, TreeNode o2){
                 if(o1.val == o2.val)
                     return 0;
                 return o1.val < o2.val ? -1 : 1;
             }
        });
        
        int sum = 0;
        
        for (int i = q.size() - 1; i >= 0; i--) {
            TreeNode curr = q.get(i);
            
            sum += curr.val;
            
            curr.val = sum;
        }
        
        return root;
    }
}