class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> maxq=new ArrayDeque<>();
        ArrayDeque<Integer> minq=new ArrayDeque<>();
        int start=0,maxlen=-1;
        for(int i=0;i<nums.length;i++)
        {
            while(!maxq.isEmpty() && nums[maxq.peekLast()]<=nums[i])
                maxq.pollLast();
            maxq.addLast(i);
            while(!minq.isEmpty() && nums[minq.peekLast()]>=nums[i])
                minq.pollLast();
            minq.addLast(i);
            while(nums[maxq.peek()]-nums[minq.peek()]>limit)
            {
                if(maxq.peek()==start)
                    maxq.poll();
                if(minq.peek()==start)
                    minq.poll();
                start++;
            }
            maxlen=Math.max(maxlen,i-start+1);
        }
        return maxlen;
    }
}