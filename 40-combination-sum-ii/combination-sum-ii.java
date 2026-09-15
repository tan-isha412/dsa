class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,new ArrayList<>());
        return ans;
    }
    public void backtrack(int start,int[] nums,int target,int currsum,List<Integer> curradded)
    {
        if(currsum==target)
        {
            ans.add(new ArrayList<>(curradded));
            return;
        }
        if(start==nums.length) return;
        for(int i=start;i<nums.length;i++)
        {
            if((i>start && nums[i]==nums[i-1])) continue;
            if(nums[i]+currsum>target) continue;
            curradded.add(nums[i]);
            backtrack(i+1,nums,target,currsum+nums[i],curradded);
            curradded.remove(curradded.size()-1);
        }
    }
}