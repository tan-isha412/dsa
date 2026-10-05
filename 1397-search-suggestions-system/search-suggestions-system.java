class Trie
{
    Trie[] ch;
    boolean eow;
    Trie()
    {
        this.ch=new Trie[26];
        this.eow=false;
    }
    public void add(String word)
    {
        Trie curr=this;
        int i=0;
        while(i<word.length())
        {
            int idx=word.charAt(i)-'a';
            if(curr.ch[idx]==null)
                curr.ch[idx]=new Trie();
            curr=curr.ch[idx];
            i++;
        }
        curr.eow=true;
    }
    public List<String> searchWPrefix(String p)
    {
        List<String> ans=new ArrayList<>();
        Trie curr=this;
        int i=0;
        while(i<p.length())
        {
            int idx=p.charAt(i)-'a';
            if(curr.ch[idx]==null)
                return ans;
            curr=curr.ch[idx];
            i++;
        }
        addwords(curr,p,ans);
        return ans;
    }
    public void addwords(Trie curr,String p,List<String> ans)
    {
        if(curr==null || ans.size()>=3)
            return;
        if(curr.eow==true) 
            ans.add(p);
        for(int i=0;i<26;i++)
        {
            if(ans.size()>=3) return;
            addwords(curr.ch[i],p+(char)(i + 97),ans);
        }
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie main=new Trie();
        List<List<String>> ans=new ArrayList<>();
        for(String p:products)
            main.add(p);
        for(int i=0;i<searchWord.length();i++)
        {
            String s=searchWord.substring(0,i+1);
            List<String> l=main.searchWPrefix(s);
            ans.add(new ArrayList<>(l));
        }
        return ans;
    }
}