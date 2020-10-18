/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        traverse(root, null);
        return root;
    }
    
    private void traverse(Node node, Node next) {
        if (node == null) return;
        node.next = next;
        traverse(node.left, node.right);
        traverse(node.right, next == null ? null : next.left);
    }
}