class MinStack {
    Stack<Integer> st=new Stack<>();
    Stack<Integer> minst=new Stack<>();
    public MinStack() {

    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty()){
            minst.push(val);
        }
        else{
            if(val<=minst.peek()){
                minst.push(val);
            }
        }
    }
    
    public void pop() {
        int top=st.peek();
        if(top==minst.peek()){
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
