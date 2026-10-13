import java.math.BigInteger;
class Solution {
    public boolean splitString(String s) {
        return backtrack(0, s, new ArrayList<>());
    }

    public boolean backtrack(int start, String s, List<BigInteger> ans) {
        if (start == s.length() && ans.size() >= 2) {
            return true;
        }

        for (int i = start; i < s.length(); i++) {
            BigInteger num = new BigInteger(s.substring(start, i + 1));

            if (num.compareTo(BigInteger.ZERO) >= 0) {
                
                if (ans.isEmpty() || ans.get(ans.size() - 1).equals(num.add(BigInteger.ONE))) {
                    ans.add(num);
                    
                    if (backtrack(i + 1, s, ans)) {
                        return true;
                    }
                    ans.remove(ans.size() - 1); 
                }
            }
        }
        return false;
    }
}
