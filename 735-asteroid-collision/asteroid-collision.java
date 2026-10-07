class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int a:asteroids)
        {
            if(a<0)
            {
                int absa=Math.abs(a);
                while(!st.isEmpty() && st.peek()>0 && st.peek()<absa)
                    st.pop();
                if(st.isEmpty())
                    st.push(a);
                else
                {
                    if(st.peek()==absa)
                        st.pop();
                    else if(st.peek()<0)
                        st.push(a);
                }
            }
            else
                st.push(a);
        }
        int k=st.size();
        int[] arr=new int[k];
        for(int i=k-1;i>=0;i--)
            arr[i]=st.pop();
        return arr;
    }
}