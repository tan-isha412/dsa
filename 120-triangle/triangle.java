class Solution {
    Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(0, 0, triangle);
    }
    private int dfs(int i, int idx, List<List<Integer>> triangle) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][idx] != null) {
            return memo[i][idx];
        }
        int down = dfs(i + 1, idx, triangle);
        int diagonal = dfs(i + 1, idx + 1, triangle);
        memo[i][idx] = triangle.get(i).get(idx) + Math.min(down, diagonal);
        return memo[i][idx];
    }
}
