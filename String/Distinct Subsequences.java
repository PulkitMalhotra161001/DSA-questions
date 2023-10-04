class Solution {
    public int distinctSubseqII(String s) {
        int index[]=new int[26], mod=(int)1e9+7, n=s.length(), dp[]=new int[n+1];
        Arrays.fill(index,-1);
        //for empty ""
        dp[0]=1;

        for(int i=1;i<=n;i++){
            int val = s.charAt(i-1) -'a';
            
            dp[i] = 2*dp[i-1]%mod;  //as obvious
            
            int prev_id = index[val];
            if(prev_id!=-1){
                //abcc
                //i=1 : dp[i]=2
                //i=2 : dp[i]=4
                //i=3 : dp[i]=8
                //i=4 : dp[i]=16-repSubSeq
                //repSubSeq is ac, abc, bc, c
                //last c at 3 where we taken c after 2nd index so we have to remove thatNow 
                dp[i]-=dp[prev_id-1];
            }
            
            if(dp[i]<=0) dp[i]+=mod;
            index[val] = i;
        }
        
        //remove empty string
        return dp[n]-1;
    }
}

//dp[i]= 2*dp[i-1]-repSubseq
//hhttps://www.youtube.com/watch?v=9UEHPiK53BA
