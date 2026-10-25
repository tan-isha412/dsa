class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> ded=new HashSet<>();
        for(String d:deadends)
            ded.add(d);
        if(ded.contains("0000") || ded.contains(target)) return -1;
        Set<String> v=new HashSet<>();
        ArrayDeque<String> q=new ArrayDeque<>();
        q.offer("0000");
        v.add("0000");
        int steps=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            for(int j=0;j<s;j++)
            {
                String curr=q.poll();
                if(curr.equals(target)) return steps;
                for(int i=0;i<4;i++)
                {
                    int dig=curr.charAt(i)-'0';
                    int up=(dig+1)%10,down=(((dig-1)%10)+10)%10;
                    StringBuilder a=new StringBuilder(curr);
                    a.setCharAt(i,(char)('0'+up));
                    if(!ded.contains(a.toString()) && !v.contains(a.toString()))
                    {
                        q.offer(a.toString());
                        v.add(a.toString());
                    }
                    a.setCharAt(i,(char)('0'+down));
                    if(!ded.contains(a.toString()) && !v.contains(a.toString()))
                    {
                        q.offer(a.toString());
                        v.add(a.toString());
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}