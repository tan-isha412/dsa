class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->
        {
            if(Math.abs(a-x)==Math.abs(b-x))
                return Integer.compare(a,b);
            return Integer.compare(Math.abs(a-x),Math.abs(b-x));
        });
        for(int a:arr)
            pq.offer(a);
        ArrayList<Integer> l=new ArrayList<>();
        while(k>0)
        {
            l.add(pq.poll());
            k--;
        }
        l.sort(null);
        return l;
    }
}