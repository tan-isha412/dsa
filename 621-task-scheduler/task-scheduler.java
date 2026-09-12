class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        int[] freq=new int[26];
        for(char ch:tasks)
            freq[ch-'A']++;
        Arrays.sort(freq);
        int maxf=freq[25];
        int gaps=(maxf-1)*n;
        for(int i=24;i>=0;i--)
        {
            if(freq[i]==0) break;
            gaps-=Math.min(maxf-1,freq[i]);
        }
        if(gaps<0) return tasks.length;
        return tasks.length+gaps;
    }
}