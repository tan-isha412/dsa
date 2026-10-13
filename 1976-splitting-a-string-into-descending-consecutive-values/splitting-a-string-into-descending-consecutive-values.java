class Solution {
    public boolean splitString(String s) {
        long firstNum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            firstNum = firstNum * 10 + (s.charAt(i) - '0');
            if (firstNum < 0) break; 
            if (backtrack(s, i + 1, firstNum)) {
                return true;
            }
        }
        return false;
    }

    private boolean backtrack(String s, int index, long prevVal) {
        if (index == s.length()) {
            return true;
        }

        long currentVal = 0;
        for (int i = index; i < s.length(); i++) {
            currentVal = currentVal * 10 + (s.charAt(i) - '0');
            if (currentVal < 0) break;
            if (currentVal == prevVal - 1) {
                if (backtrack(s, i + 1, currentVal)) {
                    return true;
                }
            } 
            else if (currentVal >= prevVal) {
                break;
            }
        }
        return false;
    }
}
