class Solution {
    public String getPermutation(int n, int k) {
        // "123456.."
        List<Integer> list=new ArrayList<>();
        
        //n!
        int fac=1;
        for(int i=1;i<=n;i++){
            list.add(i);
            fac*=i;
        }
        //recursion (k-1 because 1st permutation is 0th index and we stored in list)
        return solve(list,n,fac,k-1);
    }
    
    //total buckets (n)
    //bucket size (n-1)!
    //total permutation n*(n-1)! => n!
    
    String solve(List<Integer> list,int n,int fac,int k){
        if(n==0)    return "";
        
        //(n-1)! bucket size
        //(start with 1 + (n-1)!) cases, (start with 2 + (n-1)!) cases, (start with 3 + (n-1)!) cases and so on..
        fac/=n;
        
        //bucker no (index/bucket size)
        //inside the bucket we have n-1 numbers. Now, we need to find the index inside the bucket (bucket have (n-1)! permutations)
        //fac=(n-1)!
        return list.remove(k/fac) + solve(list,n-1,fac,k%fac);
    }
}
