// https://leetcode.com/problems/wildcard-matching/

class Solution {
    // ? means {one char} string match
    // * means {empty to infinity length} string match
    public boolean isMatch(String s, String p) {
        int n=s.length(), m=p.length();
        Boolean dp[][]=new Boolean[n][m];
        // a is string and b is pattern
        return solve(0,0,n,m,s,p,dp);
    }
    boolean solve(int i,int j,int n,int m,String a,String b,Boolean dp[][]){
        
        //if b becomes empty then (if str also empty -> true else str has something -> false)
        if(j==m)    return i==n;
        
        //string becomes empty
        if(i==n){
            //check if pattern only contains *
            while(j<m && b.charAt(j)=='*')  j++;
            return j==m;
        }
        
        if(dp[i][j]!=null)  return dp[i][j];
      
        //match found then go to next char
        if(b.charAt(j)=='?' || a.charAt(i)==b.charAt(j))    return solve(i+1,j+1,n,m,a,b,dp);
        
        //we have two options here 
        //* (matches and has this ith char) or (we ignore this * means * contains empty char)
        if(b.charAt(j)=='*')    return dp[i][j] = solve(i+1,j,n,m,a,b,dp) || solve(i,j+1,n,m,a,b,dp);
        
        //char not matched
        return false;
        
    }
}
