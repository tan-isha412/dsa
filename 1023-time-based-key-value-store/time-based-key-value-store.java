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
        Pair obj=new Pair(value,timestamp);
        m.get(key).add(obj);
    }
    public String get(String key, int timestamp) 
    {
        if(!m.containsKey(key)) return "";
        int l=0,r=m.get(key).size()-1;
        String ans="";
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(m.get(key).get(mid).value>timestamp)
                r=mid-1;
            else
            {
                ans=m.get(key).get(mid).key;
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