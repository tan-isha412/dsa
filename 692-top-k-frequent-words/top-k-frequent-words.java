class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> m=new HashMap<>();
        for(String w:words)
            m.put(w,m.getOrDefault(w,0)+1);
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->
        {
            if(m.get(a)==m.get(b))
                return a.compareTo(b);
            return Integer.compare(m.get(b),m.get(a));
        });
        pq.addAll(m.keySet());
        List<String> ans=new ArrayList<>();
        for(int i=0;i<k;i++)
            ans.add(pq.poll());
        return ans;
    }
}