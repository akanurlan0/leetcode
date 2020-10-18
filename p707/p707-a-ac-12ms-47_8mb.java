class MyLinkedList {
    
    private Node head;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = head;
        while (node != null && index > 0) {
            node = node.next;
            index--;
        }
        
        return node == null ? -1 : node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val, head);
        head = node;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        if (head == null) {
            head = new Node(val, null);
            return;
        }
        
        Node node = head;
        Node tail = null;
        while (node != null) {
            tail = node;
            node = node.next;
        }
        
        node = new Node(val, null);
        tail.next = node;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        Node prev = null;
        Node next = head;
        while (next != null && index > 0) {
            prev = next;
            next = next.next;
            index--;
        }
        
        if (index > 0) return;
        
        Node node = new Node(val, next);
        if (prev == null) {
            head = node;
        } else {
            prev.next = node;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node prev = null;
        Node node = head;
        while (node != null && index > 0) {
            prev = node;
            node = node.next;
            index--;
        }
        
        if (index > 0) return;
        
        if (prev == null) {
            head = node.next;
        } else {
            prev.next = node == null ? null : node.next;
        }
    }
    
    private class Node {
        int val;
        Node next;
        
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */