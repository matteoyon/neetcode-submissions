class MinStack {

    Deque<Integer> main;
    Deque<Integer> min;

    public MinStack() {
        main = new ArrayDeque<Integer>();
        min = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        main.push(val);
        if(min.peek() == null)
            min.push(val);
        else if(min.peek() != null && min.peek() >= val)
            min.push(val);
    }
    
    public void pop() {
        if(main.peek().equals(min.peek()))
            min.pop();
        main.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
