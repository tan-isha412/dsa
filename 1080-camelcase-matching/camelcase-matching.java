class Trie
{
    Trie[] ch;
    boolean eow;
    Trie()
    {
        ch=new Trie[58];
        eow=false;
    }
    public void insert(String word)
    {
        Trie obj=this;
        for(int i=0;i<word.length();i++)
        {
            int idx=(word.charAt(i)-'A');
            if(obj.ch[idx]==null)
                obj.ch[idx]=new Trie();
            obj=obj.ch[idx];
        }
        obj.eow=true;
    }
    public boolean search(String q,String p)
    {
        Trie obj=this;
        for(char c:q.toCharArray())
        {
            if(obj!=null && obj.ch[c-'A']!=null)
                obj=obj.ch[c-'A'];
            else
            {
                if(Character.isLowerCase(c))
                    continue;
                return false;
            }
        }
        return obj!=null && obj.eow;
    }
}
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) 
    {
        Trie obj=new Trie();
        obj.insert(pattern);
        List<Boolean> tf=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
            tf.add(obj.search(queries[i],pattern));
        return tf;
    }
    
}