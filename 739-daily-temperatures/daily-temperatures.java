class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] t=new int[temperatures.length];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=0;i<temperatures.length;i++)
        {
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i])
                t[st.peek()]=i-st.pop();
            st.push(i);
        }
        return t;
    }
}