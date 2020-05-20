class StockSpanner {

    private Stack<Pair> stack;
    
    public StockSpanner() {
        stack = new Stack<Pair>();
    }
    
    public int next(int price) {
        
        Pair current = new Pair(price, 1);
        
        while (stack.empty() == false) {
            Pair p = stack.peek();
            if (p.l <= price) {
                current.r += p.r;
                stack.pop();
            } else {
                break;
            }
        }
        
        stack.push(current);
        
        return current.r;
    }
    
    class Pair {
        public int l, r;
        
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */