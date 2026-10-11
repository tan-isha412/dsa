class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int na=0,nb=0,cost=0;
        Arrays.sort(costs,((a,b)->Integer.compare(Math.abs(b[0]-b[1]),Math.abs(a[0]-a[1]))));
        for(int[] c:costs)
        {
            if(c[0]<c[1])
            {
                if(na<costs.length/2)
                {
                    cost+=c[0];
                    na++;
                }
                else
                {
                    cost+=c[1];
                    nb++;
                }
            }
            else
            {
                if(nb<costs.length/2)
                {
                    cost+=c[1];
                    nb++;
                }
                else
                {
                    cost+=c[0];
                    na++;
                }
            }
        }
        return cost;
    }
}