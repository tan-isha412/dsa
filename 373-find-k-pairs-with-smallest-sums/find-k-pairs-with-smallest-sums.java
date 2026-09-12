class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->
        {
            return Integer.compare(nums1[a[0]]+nums2[a[1]],nums1[b[0]]+nums2[b[1]]);
        });
        for(int i=0;i<nums1.length;i++)
            pq.offer(new int[]{i,0});
        while(k>0 && !pq.isEmpty())
        {
            int[] curr=pq.poll();
            List<Integer> t=new ArrayList<>();
            t.add(nums1[curr[0]]);
            t.add(nums2[curr[1]]);
            ans.add(new ArrayList<>(t));
            k--;
            if(curr[1]<nums2.length-1)
                pq.offer(new int[]{curr[0],curr[1]+1});
        }
        return ans;
    }
}