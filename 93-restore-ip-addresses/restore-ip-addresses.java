class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        restore(0,s,new StringBuilder(),0,ans);
        return ans;
    }
    public void restore(int start,String s,StringBuilder sb,int segs,List<String> ans)
    {
        if(segs==4 && start==s.length())
        {
            ans.add(sb.toString());
            return;
        }
        if(segs==4 || start==s.length()) return;
        int len=sb.length();
        for(int i=1;i<=3;i++)
        {
            int newstart=start+i;
            if(newstart>s.length()) break;
            String attachment=s.substring(start,newstart);
            if(attachment.length()>1 && attachment.startsWith("0") || Integer.parseInt(attachment)>255) break;
            if(segs>0)
                sb.append('.');
            sb.append(attachment);
            restore(newstart,s,sb,segs+1,ans);
            sb.setLength(len);
        }
    }
}