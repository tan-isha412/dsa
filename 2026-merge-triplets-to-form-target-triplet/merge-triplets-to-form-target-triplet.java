public class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean f0 = false, f1 = false, f2 = false;
        for (int[] t : triplets) 
        {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) 
                continue;
            if (t[0] == target[0]) f0 = true;
            if (t[1] == target[1]) f1 = true;
            if (t[2] == target[2]) f2 = true;
            if (f0 && f1 && f2) 
                return true;
        }
        
        return false;
    }
}
