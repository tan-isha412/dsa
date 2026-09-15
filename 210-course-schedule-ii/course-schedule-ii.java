class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites)
        {
            int u=p[0],v=p[1];
            indegree[u]++;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }   
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0) q.offer(i);
        }        
        int k=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int curr=q.poll();
                order[k++]=curr;
                for(int nei:adj.get(curr))
                {
                    indegree[nei]--;
                    if(indegree[nei]==0) q.offer(nei);
                }
            }
        }
        return k==numCourses?order:new int[0];
    }
}