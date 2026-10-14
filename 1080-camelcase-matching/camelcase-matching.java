class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) 
            result.add(isMatch(query, pattern));
        return result;
    }
    private boolean isMatch(String query, String pattern) {
        int pIndex = 0; 
        for (int i = 0; i < query.length(); i++) 
        {
            char c = query.charAt(i);
            if (pIndex < pattern.length() && c == pattern.charAt(pIndex)) 
                pIndex++;
            else if (Character.isUpperCase(c)) 
                return false;
        }
        return pIndex == pattern.length();
    }
}
