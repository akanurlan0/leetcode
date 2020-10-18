class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> helper;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<Integer>();
        helper = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int result = helper.pop();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        int result = helper.peek();
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */