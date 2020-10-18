/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> cloned = new HashMap<>();
        return clone(node, cloned);
    }
    
    private Node clone(Node node, Map<Integer, Node> cloned) {
        Node result = new Node(node.val);
        cloned.put(node.val, result);
        
        for (Node n : node.neighbors) {
            if (cloned.containsKey(n.val)) {
                result.neighbors.add(cloned.get(n.val));
            } else {
                result.neighbors.add(clone(n, cloned));
            }
        }
        
        return result;
    }
}