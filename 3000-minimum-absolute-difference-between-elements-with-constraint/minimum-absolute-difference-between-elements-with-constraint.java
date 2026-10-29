public class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> validElements = new TreeSet<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = x; i < nums.size(); i++) {
            validElements.add(nums.get(i - x));
            int currentVal = nums.get(i);
            Integer ceil = validElements.ceiling(currentVal);
            if (ceil != null) {
                minDiff = Math.min(minDiff, ceil - currentVal);
            }
            Integer floor = validElements.floor(currentVal);
            if (floor != null) {
                minDiff = Math.min(minDiff, currentVal - floor);
            }
            if (minDiff == 0) {
                return 0;
            }
        }
        return minDiff;
    }
}
