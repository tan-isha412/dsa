class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,((a,b)->
        {
            if(a[0]==b[0])
                return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0],a[0]);
        }));
        ArrayList<int[]> arr=new ArrayList<>();
        for(int[] p:people)
            arr.add(p[1],p);
        for(int i=0;i<arr.size();i++)
            people[i]=arr.get(i);
        return people;
    }
}