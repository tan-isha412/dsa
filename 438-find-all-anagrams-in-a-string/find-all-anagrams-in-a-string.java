class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int l1=p.length();
        int l2=s.length();
        if(l2<l1) return ans;
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<l1;i++)
        {
            freq1[p.charAt(i)-'a']++;
            freq2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2)) ans.add(0);
        int l=0;
        for(int r=l1;r<l2;r++)
        {
            freq2[s.charAt(r)-'a']++;
            freq2[s.charAt(r-l1)-'a']--;
            if(Arrays.equals(freq1,freq2)) ans.add(r-l1+1);
        }
        return ans;
    }
}