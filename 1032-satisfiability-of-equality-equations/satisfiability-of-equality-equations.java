class DSU {
    char[] par;

    DSU() {
        this.par = new char[26];
        for (int i = 0; i < 26; i++) 
            par[i] = (char) ('a' + i);

    }
    public char findeq(char x) {
        if (par[x - 'a'] == x) return x;
        return par[x - 'a'] = findeq(par[x - 'a']); // Path compression
    }

    public void unioneq(char x, char y) {
        char px = findeq(x);
        char py = findeq(y);
        if (px != py) {
            par[py - 'a'] = px; // Simplified
        }
    }

}

class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU q=new DSU();
        for(String e:equations)
        {
            char c1=e.charAt(0),c2=e.charAt(3),c3=e.charAt(1);
            if(c3=='=')
                q.unioneq(c1,c2);
        }
        for(String e:equations)
        {
            char c1=e.charAt(0),c2=e.charAt(3),c3=e.charAt(1);
            if(c3=='!')
            {
                if(q.findeq(c1)==q.findeq(c2))
                    return false;
            }   
        }
        return true;
    }
}