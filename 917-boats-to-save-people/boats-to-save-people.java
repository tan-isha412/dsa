class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1,numb=0;
        while(l<r)
        {
            if(people[r]+people[l]>limit)
                r--;
            else
            {
                l++;
                r--;
            }
            numb++;
        }  
        if(l==r) numb++; 
        return  numb;
    }
}