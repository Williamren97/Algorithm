class MinStack {
    Stack<Integer> stack;//支持push pop top本身
    Stack<Integer> preMinStack;//记录历史前缀，比如-2 0 -3依次入栈，他们的最小值就是 -2 -2 -3,pop时从后往前删
    public MinStack() {
        stack = new Stack<>();
        preMinStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (preMinStack.empty()) preMinStack.push(val);
        else preMinStack.push(Math.min(preMinStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        preMinStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return preMinStack.peek();
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
