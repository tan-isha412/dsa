class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0,r=arr.length-1;
        while(l<r)
        {
            int mid=(l+r)/2;
            if(arr[mid]<x)
                l=mid+1;
            else
                r=mid;
        }
        List<Integer> lis=new ArrayList<>();
        r=l;
        l=l-1;
        while(lis.size()<k)
        {
            if(l>=0 && r<arr.length)
            {
                if(x-arr[l]<=arr[r]-x && arr[l]<arr[r])
                    lis.add(arr[l--]);
                else
                    lis.add(arr[r++]);
            }
            else if(l>=0)
                lis.add(arr[l--]);
            else
                lis.add(arr[r++]);
        }
        Collections.sort(lis);
        return lis;
    }
}