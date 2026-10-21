class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) { 
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            
            graph.get(u).put(v, val);
            graph.get(v).put(u, 1.0 / val);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);
            ans[i] = dfs(src, dst, graph, new HashSet<>(), 1.0);
        }
        return ans;
    }
    
    private double dfs(String src, String dst, Map<String, Map<String, Double>> graph, Set<String> visited, double val) {
        if (!graph.containsKey(src)) return -1.0;
        if (src.equals(dst)) return val;
        
        visited.add(src);
        for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
            String nextNode = neighbor.getKey();
            double edgeWeight = neighbor.getValue();
            if (!visited.contains(nextNode)) {
                double res = dfs(nextNode, dst, graph, visited, val * edgeWeight);
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }
}
