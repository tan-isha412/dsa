class RandomizedSet {
    ArrayList<Integer> a;
    Map<Integer,Integer> m;
    public RandomizedSet() {
        this.m=new HashMap<>();
        this.a=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(m.containsKey(val)) return false;
        a.add(val);
        m.put(val,a.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!m.containsKey(val)) return false;
        int idx=m.get(val);
        int val2=a.get(a.size()-1);
        a.set(idx,val2);
        a.remove(a.size()-1);
        m.put(val2,idx);
        m.remove(val);
        return true;
    }
    private Random rand = new Random();

public int getRandom() {
    int randomIndex = rand.nextInt(a.size());
        return a.get(randomIndex);
}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */