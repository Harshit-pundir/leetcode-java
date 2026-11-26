class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if(minSt.isEmpty() || value <= minSt.peek()) minSt.push(value);
    }
    
    public void pop() {
        if(!minSt.isEmpty() && minSt.peek().equals(st.peek())) minSt.pop();
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

