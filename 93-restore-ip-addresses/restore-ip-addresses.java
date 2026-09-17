class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ans;
        }
        restore(0, s, new StringBuilder(), 0, ans);
        return ans;
    }
    private void restore(int start, String s, StringBuilder sb, int segmentCount, List<String> ans) {
        if (segmentCount == 4 && start == s.length()) 
        {
            ans.add(sb.toString());
            return;
        }
        if (segmentCount == 4 || start == s.length()) return; //OR so it kinda means like one of them got true other is false
        int len = sb.length();
        for (int i = 1; i <= 3; i++) 
        {
            if (start + i > s.length()) break;
            String segment = s.substring(start, start + i);
            if ((segment.length() > 1 && segment.startsWith("0")) || Integer.parseInt(segment) > 255)
                break; 
            if (segmentCount > 0)
                sb.append(".");
            sb.append(segment);
            restore(start + i, s, sb, segmentCount + 1, ans);
            sb.setLength(len);
        }
    }
}
