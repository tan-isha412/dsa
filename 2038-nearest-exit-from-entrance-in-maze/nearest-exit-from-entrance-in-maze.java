class Solution {
    int[] r={-1,1,0,0};
    int[] c={0,0,-1,1};
    public int nearestExit(char[][] maze, int[] entrance) {
        if(maze[entrance[0]][entrance[1]]=='+') return -1;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+';
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            if (!(curr[0] == entrance[0] && curr[1] == entrance[1])) 
            {
                if (curr[0] == 0 || curr[0] == maze.length - 1 || 
                    curr[1] == 0 || curr[1] == maze[0].length - 1) 
                    return curr[2];
            }
            for(int i=0;i<4;i++)
            {
                int newr=curr[0]+r[i],newc=curr[1]+c[i];
                if(newr>=0 && newc>=0 && newr<maze.length && newc<maze[0].length && maze[newr][newc]=='.')
                {
                    q.offer(new int[]{newr,newc,curr[2]+1});
                    maze[newr][newc]='+';
                }
            }
        }
        return -1;
    }
}