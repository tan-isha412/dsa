class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        boolean[] unused = new boolean[n + 1];
        backtrack(0, n, unused, ans);
        return ans;
    }
    public boolean backtrack(int idx, int n, boolean[] unused, int[] ans) {
        if (idx == ans.length) {
            return true;
        }
        if (ans[idx] != 0) {
            return backtrack(idx + 1, n, unused, ans);
        }
        for (int i = n; i >= 1; i--) {
            if (unused[i]) continue;

            if (i == 1) {
                ans[idx] = 1;
                unused[1] = true;
                if (backtrack(idx + 1, n, unused, ans)) return true;
                ans[idx] = 0;
                unused[1] = false;
            } else {
                int targetIdx = idx + i;
                if (targetIdx < ans.length && ans[targetIdx] == 0) {
                    ans[idx] = i;
                    ans[targetIdx] = i;
                    unused[i] = true;

                    if (backtrack(idx + 1, n, unused, ans)) return true;
                    ans[idx] = 0;
                    ans[targetIdx] = 0;
                    unused[i] = false;
                }
            }
        }
        return false; // Return false if no valid number fits here
    }
}
