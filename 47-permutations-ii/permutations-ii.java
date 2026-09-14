class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] b=new boolean[nums.length];
        backtrack(nums,b,new ArrayList<>());
        return ans;
    }
    public void backtrack(int[] nums,boolean[] b,List<Integer> l)
    {
        if(l.size()==nums.length)
        {
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if((i>0 && !b[i-1] && nums[i]==nums[i-1]) || b[i]) continue;
            l.add(nums[i]);
            b[i]=true;
            backtrack(nums,b,l);
            b[i]=false;
            l.remove(l.size()-1);
        }
    }
}