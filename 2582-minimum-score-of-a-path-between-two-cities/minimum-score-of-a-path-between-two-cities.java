import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        // 1. Build the adjacency list graph
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }
        
        // 2. Standard BFS/DFS without backtracking
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) 
        {
            int node = queue.poll();
            for (int[] neighbor : adj[node]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                minScore = Math.min(minScore, weight);
                if (!visited[nextNode]) 
                {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        return minScore;
    }
}
