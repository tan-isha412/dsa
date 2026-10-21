class Solution {
    int[] row = {1, -1, 0, 0};
    int[] col = {0, 0, 1, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }
        return answer;
    }

    private void dfs(int[][] heights,int r,int c,boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++)
        {
            int newR = r + row[i];
            int newC = c + col[i];
            if (newR < 0 || newC < 0 ||newR >= heights.length ||newC >= heights[0].length || visited[newR][newC] || heights[newR][newC] < heights[r][c]) 
                continue;
            dfs(heights, newR, newC, visited);
        }
    }
}