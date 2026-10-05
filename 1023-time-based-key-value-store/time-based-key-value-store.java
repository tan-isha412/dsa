class Pair
{
    String key;
    int value;
    Pair(String key,int value)
    {
        this.key=key;
        this.value=value;
    }
}
class TimeMap {
    Map<String,List<Pair>> m;
    public TimeMap() 
    {
        m=new HashMap<>();
    }
    public void set(String key, String value, int timestamp) 
    {
        if(!m.containsKey(key))
            m.put(key,new ArrayList<>());
        m.get(key).add(new Pair(value,timestamp));
    }
    public String get(String key, int timestamp) 
    {
        if(!m.containsKey(key)) return "";
        String ans="";
        List<Pair> g=m.get(key);
                int l=0,r=g.size()-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(g.get(mid).value>timestamp)
                r=mid-1;
            else
            {
                ans=g.get(mid).key;
                l=mid+1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */