//gfg

class Solution
{
    
    public long findRank(String S)
    {
        int n=S.length();
        int arr[]=new int[n];
        long dp[]=new long[n];
        dp[0]=1;
        
        
        //fill factorial array
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]*i;
        }
        
        //check for every index
        for(int i=0;i<n;i++){
            int temp=0;
            
            //find how many values smaller than ith value are present
            for(int j=i+1;j<n;j++){
                if(S.charAt(j)<S.charAt(i)){
                    temp++;
                }
            }
            
            //fill in the array
            arr[i]=temp;
        }
        
        //now we know how many values smaller than ith value are present (in front of ith value)
        long ans=0;
        for(int i=0;i<n;i++){
            
            //now the smaller values need to be before ith
            //total combination will be before of ith factorial
            ans+=arr[i]*dp[n-1-i];
            
        }
        
        //upto this before values smaller values are ans
        //so this value is ans+1
        return ans+1;
        
    }
    
    //youtube.com/watch?v=2VIxVd50lB4
}
