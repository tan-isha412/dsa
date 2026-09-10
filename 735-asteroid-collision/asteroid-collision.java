class Solution {
    public int[] asteroidCollision(int[] asteroids) 
    {
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<asteroids.length;i++)
        {
            boolean alive=true;
            if(asteroids[i]<0)
            {
                int curr=Math.abs(asteroids[i]);
                while(!st.isEmpty() && st.peek()>0 && curr>st.peek())
                    st.pop();
                if(!st.isEmpty() && st.peek()>0)
                {
                    if(st.peek()==curr)
                        st.pop();
                    alive=false;
                }
                if(alive)
                    st.push(asteroids[i]);
            }
            else
                st.push(asteroids[i]);
        }
        int s=st.size();
        int[] ans=new int[s];
        while(!st.isEmpty())
            ans[--s]=st.pop();
        return ans;
    }
}