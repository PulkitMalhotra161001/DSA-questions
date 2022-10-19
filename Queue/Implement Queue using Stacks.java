class MyQueue {
    Stack<Integer> st1, st2;
    int front;
    
    public MyQueue() {
        st1=new Stack<>();
        st2=new Stack<>();
        front=-1;
    }
    
    public void push(int x) {
        if(st1.isEmpty()){
            front=x;
        }   
        st1.push(x);
    }
    
    // the worst case cannot occur again for a long time, thus amortizing its cost.
    public int pop() {
        // O(n)
        if(st2.isEmpty()){
            while(!st1.isEmpty())    st2.push( st1.pop() );
        }
        // O(1)
        return st2.pop();
    }
    
    public int peek() {
        return st2.isEmpty() ? front : st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}
