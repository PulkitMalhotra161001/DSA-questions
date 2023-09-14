// https://leetcode.com/problems/permutation-sequence/

class Solution {
    
    String ans;
    public String getPermutation(int n, int k) {
        
        // "123456.."
        List<Integer> str=new ArrayList<>();
        
        //n!
        int fac=1;
        ans="";
        
        for(int i=1;i<=n;i++){
            str.add(i);
            fac*=i;
        }
        
        //recursion (k-1 because 1st permutation is 0th index and we stored in list)
        solve(str,n,fac,k-1);
        return ans;
    }
    
    void solve(List<Integer> s,int n,int fac,int k){
        //string is empty
        if(n==0)    return;
        
        //simply imagine like a bucket where permutation can start with any single character
        //(start with 1 + (n-1)!) cases, (start with 2 + (n-1)!) cases, (start with 3 + (n-1)!) cases and so on..
        //so factorial will be n-1      =>      (n-1)! cases
        fac/=n;
        
        //this will decide the bucket 
        int start_with=k/fac;
        
        //means start with cth character
        ans+=s.remove(start_with);
        
        //inside the bucket we have n-1 numbers and n-1! cases
        //now we need to find the index inside the bucket (bucket have (n-1)! permutations)
        //fac=(n-1)!
        solve(s, n-1, fac, k%fac);
    }
}
