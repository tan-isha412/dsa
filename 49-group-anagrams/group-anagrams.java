class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> m=new HashMap<>();
        for(String str:strs)
        {
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            if(!m.containsKey(sorted))
                m.put(sorted,new ArrayList<>());
            m.get(sorted).add(str);
        }
        return new ArrayList<>(m.values());
    }
}