class Pair
{
    int idx;
    double prob;
    Pair(int idx,double p)
    {
        this.idx=idx;
        this.prob=p;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] p=new double[n];   
        Arrays.fill(p,0.00);
        p[start_node]=1.00;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        Set<Integer> v=new HashSet<>();
        pq.offer(new Pair(start_node,1.00));
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            v.add(curr.idx);
            if(curr.prob<p[curr.idx]) continue;
            for(Pair nei:adj.get(curr.idx))
            {
                if(!v.contains(nei.idx) && curr.prob*nei.prob>p[nei.idx])
                {
                    p[nei.idx]=curr.prob*nei.prob;
                    pq.offer(new Pair(nei.idx,p[nei.idx]));
                }
            }
        }
        return p[end_node];
    }
}