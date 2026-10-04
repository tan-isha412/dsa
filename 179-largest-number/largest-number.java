class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->(String.valueOf(b)+String.valueOf(a)).compareTo(String.valueOf(a)+String.valueOf(b)));
        for(int i=0;i<nums.length;i++)
            pq.offer(nums[i]);
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty())
            sb.append(String.valueOf(pq.poll()));
        return sb.toString().startsWith("0")?"0":sb.toString();
    }
}