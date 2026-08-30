class MapSum {
    int val;
    MapSum[] ch;
    boolean eow;
    Map<String,Integer> m;
    public MapSum() {
        ch=new MapSum[26];
        m=new HashMap<>();
    }
    
    public void insert(String key, int val) {
        MapSum curr=this;
        int del=val-m.getOrDefault(key,0);
        m.put(key,val);
        for(int i=0;i<key.length();i++)
        {
            int idx=key.charAt(i)-'a';
            if(curr.ch[idx]==null)
                curr.ch[idx]=new MapSum();
            curr.ch[idx].val+=del;
            curr=curr.ch[idx];
        }
        curr.eow=true;
    }
    
    public int sum(String prefix) {
        MapSum curr=this;
        for(int i=0;i<prefix.length();i++)
        {
            int idx=prefix.charAt(i)-'a';
            if (curr.ch[idx] == null) {
                return 0; 
            }
            curr=curr.ch[idx];
        }
        return curr.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */