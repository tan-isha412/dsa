class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int maxf=-1,maxlen=-1;
        int l=0;
        for(int r=0;r<s.length();r++)
        {
            char ri=s.charAt(r);
            freq[ri-'A']++;
            maxf=Math.max(maxf,freq[ri-'A']);
            while(r-l+1-maxf>k)
            {
                freq[s.charAt(l)-'A']--;
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}