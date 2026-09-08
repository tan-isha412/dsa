class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> m=new HashMap<>();
        for(int i=0;i<equations.size();i++)
        {
            String one=equations.get(i).get(0);
            String two=equations.get(i).get(1);
            m.computeIfAbsent(one, k -> new HashMap<>()).put(two, values[i]);
            m.computeIfAbsent(two, k -> new HashMap<>()).put(one, 1.0 / values[i]);
        }
        double[] ans=new double[queries.size()];

        for(int i=0;i<queries.size();i++)
        {
            if(!m.containsKey(queries.get(i).get(0)) || !m.containsKey(queries.get(i).get(1)))
            ans[i]=-1.00;
            else
            ans[i]=dfs(queries.get(i).get(0),queries.get(i).get(1),new HashSet<>(),m,1.00);
        }
        return ans;
    }
    public double dfs(String s1,String s2,Set<String> v,Map<String,Map<String,Double>> m,double a)
    {
        if(s1.equals(s2))
            return a;
        v.add(s1);
        for(Map.Entry<String,Double> map:m.get(s1).entrySet())
        {
            if(!v.contains(map.getKey()))
            {
            double back=dfs(map.getKey(),s2,v,m,a*map.getValue());
            if(back!=-1.00) return back;
            }
        }
        return -1.00;
    }
}