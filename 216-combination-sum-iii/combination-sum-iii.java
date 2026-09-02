class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(ans,1,0,new ArrayList<>(),k,n);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,int start,int sum,List<Integer> l,int k,int n)
    {
        if(sum>n) return;
        if(l.size()==k)
        {
            if(sum==n)
                ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=start;i<=9;i++)
        {
            l.add(i);
            sum+=i;
            backtrack(ans,i+1,sum,l,k,n);
            sum-=l.get(l.size()-1);
            l.remove(l.size()-1);
        }
    }
}