class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if (s == null || s.length() < p.length()) 
            return ans;
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(char ch:p.toCharArray())
            f1[ch-'a']++;
        for(char ch:s.substring(0,p.length()).toCharArray())
            f2[ch-'a']++;
        if(Arrays.equals(f1,f2)) ans.add(0);
        for(int i=p.length();i<s.length();i++)
        {
            char r=s.charAt(i);
            char l=s.charAt(i-p.length());
            f2[r-'a']++;
            f2[l-'a']--;
            if(Arrays.equals(f1,f2)) ans.add(i-p.length()+1);
        }
        return ans;
    }
}