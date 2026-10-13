class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        backtrack(0, nums, l, ans);
        return ans;
    }
    
    public void backtrack(int idx, int[] nums, List<Integer> l, List<List<Integer>> ans) {
        if (l.size() >= 2) {
            ans.add(new ArrayList<>(l));
        }
        
        Set<Integer> used = new HashSet<>();
        for (int i = idx; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            
            if (l.isEmpty() || l.get(l.size() - 1) <= nums[i]) {
                used.add(nums[i]); 
                l.add(nums[i]);
                backtrack(i + 1, nums, l, ans);
                l.remove(l.size() - 1); 
            }
        }
    }
}
