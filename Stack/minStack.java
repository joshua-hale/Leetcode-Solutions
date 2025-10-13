class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(mins.isEmpty() || val <= mins.peek()) {
            mins.push(val);
        }
    }
    
    public void pop() {
        int v = stack.pop();
        if (v == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
