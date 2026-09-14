class Pair
{
    int p;
    int span;
    Pair(int price,int span)
    {
        this.p=price;
        this.span=span;
    }    
}
class StockSpanner {
    ArrayDeque<Pair> st1;
    public StockSpanner() {
        st1=new ArrayDeque<>();
    }
    public int next(int price) {
        int num=1;
        while(!st1.isEmpty() && st1.peek().p<=price)
            num+=st1.pop().span;
        st1.push(new Pair(price,num));
        return num;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */