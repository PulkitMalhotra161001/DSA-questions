//https://leetcode.com/problems/longest-palindromic-subsequence/description/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][]=new int[s.length()][s.length()];
        return solve(s,0,s.length()-1,dp);
    }
    int solve(String s,int i,int j,int dp[][]){
        if(i==j)    return 1;
        if(i>j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return solve(s,i+1,j-1,dp)+2;
        }
        return dp[i][j]=Math.max( solve(s,i+1,j,dp), solve(s,i,j-1,dp) );
    }
}
