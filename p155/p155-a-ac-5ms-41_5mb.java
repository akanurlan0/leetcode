class MinStack {

    private List<Integer> list;
    private Queue<Integer> pq;
    
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<Integer>();
        pq = new PriorityQueue<Integer>();
    }
    
    public void push(int x) {
        list.add(x);
        pq.add(x);
    }
    
    public void pop() {
        int item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        pq.remove(item);
    }
    
    public int top() {
        return list.get(list.size() - 1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */