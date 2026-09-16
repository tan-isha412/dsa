class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int longestChain = 1;
        for (String word : words) 
        {
            int currentLength = 1;
            for (int i = 0; i < word.length(); i++) 
            {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String predecessor = sb.toString();
                if (dp.containsKey(predecessor)) 
                    currentLength = Math.max(currentLength, dp.get(predecessor) + 1);
            }
            dp.put(word, currentLength);
            longestChain = Math.max(longestChain, currentLength);
        }
        return longestChain;
    }
}
