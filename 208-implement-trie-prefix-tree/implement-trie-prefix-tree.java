class Trie {
    Trie[] ch;
    boolean eow;
    public Trie() {
        this.ch=new Trie[26];
        this.eow=false;
    }
    
    public void insert(String word) {
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
    
    public boolean search(String word) {
        Trie curr=this;
        int i=0;
        while(i<word.length())
        {
            int idx=word.charAt(i)-'a';
            if(curr.ch[idx]==null)
                return false;
            curr=curr.ch[idx];
            i++;
        }
        return curr.eow;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        int i=0;
        while(i<prefix.length())
        {
            int idx=prefix.charAt(i)-'a';
            if(curr.ch[idx]==null)
                return false;
            curr=curr.ch[idx];
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */