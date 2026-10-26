class Pair
{
    int nei;
    double prob;
    Pair(int nei,double prob)
    {
        this.nei=nei;
        this.prob=prob;
    }    
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0],v=edges[i][1];
            double val=succProb[i];
            adj.get(u).add(new Pair(v,val));
            adj.get(v).add(new Pair(u,val));
        }
        double[] p=new double[n];
        p[start_node]=1.00;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        pq.offer(new Pair(start_node,1));
        while(!pq.isEmpty())
        {
            Pair curr=pq.poll();
            if(curr.nei==end_node) return curr.prob;
            if(curr.prob<p[curr.nei]) continue;
            for(Pair ne:adj.get(curr.nei))
            {
                double nextProb = curr.prob * ne.prob;
        
                if (nextProb > p[ne.nei]) {
                    p[ne.nei] = nextProb;
                    pq.offer(new Pair(ne.nei, nextProb));
                }
            }
        }
        return 0.0;
    }
}