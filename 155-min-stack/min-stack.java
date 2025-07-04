class MinStack {
    List<Integer> stack;
    List<Integer> mins;

    public MinStack() {
        stack = new ArrayList<>();
        mins = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(mins.size() == 0 || val <= mins.get(mins.size()-1)){
            mins.add(val);
        }
    }
    
    public void pop() {
        int popped = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        if(popped == mins.get(mins.size()-1)){
            mins.remove(mins.size()-1);
        }

    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return mins.get(mins.size()-1);
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