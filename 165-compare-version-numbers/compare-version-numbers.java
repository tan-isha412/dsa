class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        for(String s:version1.split("\\."))
            a1.add(Integer.parseInt(s));
        for(String s:version2.split("\\."))
            a2.add(Integer.parseInt(s));
        int i=0,j=0;
        while(i<a1.size() && j<a2.size())
        {
            if(a1.get(i)>a2.get(j))
                return 1;
            else if(a1.get(i)<a2.get(j))
                return -1;
            else
            {
                i++;
                j++;
            }
        }
        while(i<a1.size())
        {
            if(a1.get(i)==0) i++;
            else return 1;
        }
        while(j<a2.size())
        {
            if(a2.get(j)==0) j++;
            else return -1;
        }
        return 0;
    }
}