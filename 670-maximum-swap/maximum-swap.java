class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] lastseen = new int[10]; 
        for (int i = 0; i < digits.length; i++) 
            lastseen[digits[i] - '0'] = i;

        for (int i = 0; i < digits.length; i++) 
        {
            for (int j = 9; j > digits[i] - '0'; j--) 
            {
                if (lastseen[j] > i) 
                {
                    char temp = digits[i];
                    digits[i] = digits[lastseen[j]];
                    digits[lastseen[j]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
}
