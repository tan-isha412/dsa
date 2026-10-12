class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonated = Math.max(maxDetonated, dfs(i, bombs, visited));
        }
        return maxDetonated;
    }
    private int dfs(int curr, int[][] bombs, boolean[] visited) {
        visited[curr] = true;
        int count = 1;
        long x1 = bombs[curr][0];
        long y1 = bombs[curr][1];
        long r1 = bombs[curr][2];

        for (int next = 0; next < bombs.length; next++) {
            if (!visited[next]) {
                long x2 = bombs[next][0];
                long y2 = bombs[next][1];

                long distSq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

                if (distSq <= r1 * r1) {
                    count += dfs(next, bombs, visited);
                }
            }
        }
        return count;
    }
}
