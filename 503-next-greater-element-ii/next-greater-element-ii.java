class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans=new int[nums.length];
        ArrayDeque<Integer> st=new ArrayDeque<>();
        for(int i=2*nums.length-1;i>=0;i--)
        {
            int idx=i%nums.length;
            while(!st.isEmpty() && nums[idx]>=st.peek())
                st.pop();
            ans[idx]=st.isEmpty()?-1:st.peek();
            st.push(nums[idx]);
        }
        return ans;
    }
}