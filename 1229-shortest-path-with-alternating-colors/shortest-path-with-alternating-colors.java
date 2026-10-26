public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            adj.get(edge[0]).add(new int[]{edge[1], 0});
        }
        for (int[] edge : blueEdges) {
            adj.get(edge[0]).add(new int[]{edge[1], 1});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, -1});
        
        visited[0][0] = true;
        visited[0][1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int steps = curr[1];
            int lastColor = curr[2];
            if (ans[node] == -1) {
                ans[node] = steps;
            }
            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int nextColor = neighbor[1];

                if (nextColor != lastColor && !visited[nextNode][nextColor]) {
                    visited[nextNode][nextColor] = true;
                    queue.offer(new int[]{nextNode, steps + 1, nextColor});
                }
            }
        }
        return ans;
    }
}
