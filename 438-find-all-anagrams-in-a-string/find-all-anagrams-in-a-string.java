class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l=new ArrayList<>();
        if(s.length()<p.length()) return l;
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(int i=0;i<p.length();i++)
        {
            f1[p.charAt(i)-'a']++;
            f2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(f1,f2)) l.add(0);
        for(int i=p.length();i<s.length();i++)
        {
            f2[s.charAt(i)-'a']++;
            f2[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(f1,f2))
                l.add(i-p.length()+1);
        }
        return l;
    }
}