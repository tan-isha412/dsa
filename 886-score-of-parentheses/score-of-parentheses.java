class Solution {
    public int scoreOfParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int currentScore = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(currentScore);
                currentScore = 0;
            } else {
                currentScore = stack.pop() + Math.max(2 * currentScore, 1);
            }
        }

        return currentScore;
    }
}
