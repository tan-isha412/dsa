class Solution {
    public int snakesAndLadders(int[][] board) {
        int dest=board.length*board.length;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        Set<Integer> v=new HashSet<>();
        q.offer(1);
        v.add(1);
        int steps=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int j=0;j<s;j++)
            {
            int curr=q.poll();
            if(curr==dest) return steps;
            for(int i=1;i<=6;i++)
            {
                if(curr+i>dest) continue;
                int next=curr+i;
                int[] coord=get(next,board.length);
                if(board[coord[0]][coord[1]]!=-1)
                    next=board[coord[0]][coord[1]];
                if(!v.contains(next))
                {
                    q.offer(next);
                    v.add(next);
                }
            }
            }
            steps++;
        }
        return -1;
    }
    public int[] get(int n,int len)
    {
        int row=(n-1)/len;
        int col=(n-1)%len;
        if(row%2==1)
            col=len-1-col;
        return new int[]{len-1-row,col};
    }
}