class Solution {
    public void rotate(int[] nums, int k) {
    if (nums == null || nums.length <= 1 || k == 0) return;
    
    int n = nums.length;
    k = k % n; // Handle cases where k is greater than array length
    if (k == 0) return;

    // The number of independent cycles is equal to gcd(n, k)
    int cycles = gcd(n, k);
    for (int start = 0; start < cycles; start++) {
        rot(nums, start, k);
    }
}

// Helper method to calculate Greatest Common Divisor
private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

public void rot(int[] nums, int start, int k) {
    int curr = start;
    int temp = nums[start];
    do {
        curr = (curr + k) % nums.length;
        int temp2 = nums[curr];
        nums[curr] = temp;
        temp = temp2;
    } while (curr != start);
}

}