//Function to find the length of longest common subsequence in two strings.
static int lcs(int m, int n, String A, String B){
    
    // return tabulation(m,n,A,B,new Integer[m+1][n+1]);
    return Memoization(A,B,m,n,new Integer[m+1][n+1]);
}

static int tabulation(int m,int n,String A,String B,Integer dp[][]){
    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0 || j==0)
                dp[i][j]=0;
            else{
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    return dp[m][n];
}

static int Memoization(String S1, String S2, int m, int n, Integer dp[][]){
    if(m==0 || n==0)    return dp[m][n]=0;
    if(dp[m][n]!=null)    return dp[m][n];
    if(S1.charAt(m-1)==S2.charAt(n-1)){
        return dp[m][n]=1+Memoization(S1,S2,m-1,n-1,dp);
    }
    return dp[m][n]=Math.max( Memoization(S1,S2,m-1,n,dp), Memoization(S1,S2,m,n-1,dp));
}
