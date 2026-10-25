class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int city = 1; city < n; city++) {
            if (degree[city] == 1) {
                queue.offer(city);
            }
        }
        long[] people = new long[n];
        Arrays.fill(people, 1);
        long fuel = 0;
        while (!queue.isEmpty()) 
        {
            int city = queue.poll();
            fuel += (people[city] + seats - 1) / seats;
            degree[city]--;
            for (int neighbour : adj.get(city)) 
            {
                if (degree[neighbour] == 0) {
                    continue;
                }
                people[neighbour] += people[city];
                degree[neighbour]--;
                if (neighbour != 0 && degree[neighbour] == 1) 
                    queue.offer(neighbour);
            }
        }

        return fuel;
    }
}