class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                for (int j = 0; j < n; j++) {
                    result[j] += Math.abs(i - j);
                }
            }
        }

        return result;
    }
}