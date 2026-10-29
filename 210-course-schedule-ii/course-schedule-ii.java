class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses==1)
            return new int[]{0};
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] p:prerequisites)
        {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        int[] ans=new int[numCourses];
        int k=0;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                int curr=q.poll();
                ans[k++]=curr;
                for(int nei:adj.get(curr))
                {
                    indegree[nei]--;
                    if(indegree[nei]==0)
                        q.offer(nei);
                }
            }
        }
        return k==numCourses?ans:new int[0];
    }
}