class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new double[]{(double)(edges[i][1]),succProb[i]});
            adj.get(edges[i][1]).add(new double[]{(double)(edges[i][0]),succProb[i]});
        }
        double[] prob=new double[n];
        Arrays.fill(prob,Double.MIN_VALUE);
        prob[start_node]=1.00;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        pq.offer(new double[]{(double)(start_node),1.00});
        while(!pq.isEmpty())
        {
            double[] curr=pq.poll();
            int u=(int)curr[0];
            if(u==end_node) return curr[1];
            if(prob[u]>curr[1]) continue;
            for(double[] nei:adj.get(u))
            {
                int neig=(int)nei[0];
                if(prob[neig]<curr[1]*nei[1])
                {
                    prob[neig]=curr[1]*nei[1];
                    pq.offer(new double[]{nei[0],prob[neig]});
                }
            }
        }
        return 0.00;
    }
}