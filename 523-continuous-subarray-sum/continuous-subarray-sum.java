class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> seenRemainders = new HashSet<>();
        int prefixSum = 0;
        int prevRemainder = 0; 
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currentRemainder = prefixSum % k;
            if (seenRemainders.contains(currentRemainder)) {
                return true;
            }
            seenRemainders.add(prevRemainder);
            prevRemainder = currentRemainder;
        }
        return false;
    }
}
