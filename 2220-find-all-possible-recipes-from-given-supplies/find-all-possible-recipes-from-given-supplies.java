class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String,Integer> req=new HashMap<>();
        Map<String,List<String>> ingtoRec=new HashMap<>();
        for(int i=0;i<recipes.length;i++)
        {
            for(String ing:ingredients.get(i))
            {
                if(!ingtoRec.containsKey(ing))
                    ingtoRec.put(ing,new ArrayList<>());
                ingtoRec.get(ing).add(recipes[i]);
                req.put(recipes[i],req.getOrDefault(recipes[i],0)+1);
            }
        }
        List<String> ans=new ArrayList<>();
        ArrayDeque<String> q=new ArrayDeque<>();
        for(String sup:supplies)
            q.offer(sup);
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int i=0;i<s;i++)
            {
                String curr=q.poll();
                for(String recp:ingtoRec.getOrDefault(curr,new ArrayList<>()))
                {
                    req.put(recp,req.get(recp)-1);
                    if(req.get(recp)==0)
                    {
                        q.offer(recp);
                        ans.add(recp);
                    }
                }
            }
        }
        return ans;
    }
}