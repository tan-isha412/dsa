class Solution {
    public long dividePlayers(int[] skill) {
        int sum=0,teams=skill.length/2;
        for(int s:skill) sum+=s;
        if(sum%teams!=0) return -1;
        Arrays.sort(skill);
        long find=sum/teams,chem=0;
        int l=0,r=skill.length-1;
        while(l<r)
        {
            if(skill[l]+skill[r]==find)
                chem+=skill[l++]*skill[r--];
            else
                return -1;
        }
        return chem;
    }
}