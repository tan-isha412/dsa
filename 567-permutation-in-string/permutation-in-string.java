class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        if(s2.length()<s1.length()) return false;
        for(int i=0;i<s1.length();i++)
        {
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2)) return true;
        for(int i=s1.length();i<s2.length();i++)
        {
            freq2[s2.charAt(i-s1.length())-'a']--;
            freq2[s2.charAt(i)-'a']++;
            if(Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }
}