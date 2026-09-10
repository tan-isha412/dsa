class Pair
{
    int time;
    String val;
    Pair(int time,String val)
    {
        this.time=time;
        this.val=val;
    }
}
class TimeMap {
    Map<String,List<Pair>> m;
    public TimeMap() {
        m=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!m.containsKey(key))
            m.put(key,new ArrayList<>());
        m.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if (!m.containsKey(key)) {
            return "";
        }
        List<Pair> list = m.get(key);
        
        int left = 0;
        int right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).val; 
                left = mid + 1;          
            } else {
                right = mid - 1;         
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */