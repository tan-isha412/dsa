class Pair
{
    int num;
    int mn;
    Pair(int num,int mn)
    {
        this.num=num;
        this.mn=mn;
    }
}
class MinStack {
    ArrayDeque<Pair> st;
    int minm;
    public MinStack() {
        st=new ArrayDeque<>();
        minm=Integer.MAX_VALUE;
    }
    
    public void push(int value) {
        if(minm>value)
            minm=value;
        st.push(new Pair(value,minm));
    }
    
    public void pop() {
        int going=st.pop().num;
        if(st.isEmpty())
            minm=Integer.MAX_VALUE;
        else
            minm=st.peek().mn;
    }
    
    public int top() {
        return st.peek().num;
    }
    
    public int getMin() {
        return st.peek().mn;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */