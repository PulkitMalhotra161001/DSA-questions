// https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#

// The maximum length Longest Common Suffix is the longest common substring. 
  int longestCommonSubstr(String S1, String S2, int n, int m){
      int dp[][]=new int[n+1][m+1];
      int ans=0;
      for(int i=1;i<=n;i++){
          for(int j=1;j<=m;j++){
              // If last characters match, then we reduce both lengths by 1 
              if(S1.charAt(i-1)==S2.charAt(j-1)){
                  dp[i][j]=1+dp[i-1][j-1];
                  ans=Math.max(dp[i][j],ans);
              }
          }
      }

      return ans;
  }
