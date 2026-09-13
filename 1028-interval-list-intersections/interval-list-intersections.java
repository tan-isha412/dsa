class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length)
        {
            int start=Math.max(firstList[i][0],secondList[j][0]);
            int end=Math.min(firstList[i][1],secondList[j][1]);
            if(start<=end)
            {
                List<Integer> t=new ArrayList<>();
                t.add(start);
                t.add(end);
                ans.add(new ArrayList<>(t));
            }
            if(firstList[i][1]<secondList[j][1]) i++;
            else j++;
        }
        int[][] a=new int[ans.size()][2];
        for(i=0;i<ans.size();i++)
        {
            a[i][0]=ans.get(i).get(0);
            a[i][1]=ans.get(i).get(1);
        }
        return a;
    }
}