class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f=new int[26];
        for(char c:tasks)
            f[c-'A']++;
        Arrays.sort(f);
        int gaps=(f[25]-1)*n;
        for(int i=24;i>=0;i--)
            gaps-=Math.min(f[i],f[25]-1);
        if(gaps<0) return tasks.length;
        return tasks.length+gaps;
    }
}