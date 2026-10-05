class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combination(candidates,target,0,0,new ArrayList<>());
        return ans;
    }
    public void combination(int[] nums,int target,int sum,int start,List<Integer> l)
    {
        if(sum==target)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        if(sum>target || start==nums.length) return;
        for(int i=start;i<nums.length;i++)
        {
            if(i>start && nums[i]==nums[i-1]) continue;
            l.add(nums[i]);
            combination(nums,target,sum+nums[i],i+1,l);
            l.remove(l.size()-1);
        }
    }
}