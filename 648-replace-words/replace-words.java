class Trie
{
    Trie ch[];
    boolean eow;
    Trie()
    {
        this.ch=new Trie[26];
        this.eow=false;
    }
    public void insert(String s)
    {
        Trie curr=this;
        for(int i=0;i<s.length();i++)
        {
            int idx=s.charAt(i)-'a';
            if(curr.ch[idx]==null)
                curr.ch[idx]=new Trie();
            curr=curr.ch[idx];
        }
        curr.eow=true;
    }
    public boolean search(String s)
    {
        Trie curr=this;
        for(int i=0;i<s.length();i++)
        {
            int idx=s.charAt(i)-'a';
            if(curr.ch[idx]==null)
                return false;
            curr=curr.ch[idx];
        }
        return curr.eow;
    }
    public int minlenword(String s)
    {
        Trie curr=this;
        for(int i=0;i<s.length();i++)
        {
            if(curr.search(s.substring(0,i+1)))
                return i+1;
        }
        return 0;
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder sb=new StringBuilder();
        Trie obj=new Trie();
        for(String s:dictionary)
            obj.insert(s);
        for(String s:sentence.split(" "))
        {
            int ans=obj.minlenword(s);
            if(ans==0)
                sb.append(s);
            else
                sb.append(s.substring(0,ans));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}