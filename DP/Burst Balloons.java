class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        
        //Gap strategy
        for(int g=0;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                
                /*now we have ranges like = 3,1,5,8,31,15,58,315,158,3158
                eg. 315 we have 6 case to burst this
                burst 3 then burst 1 or burst 3 then burst 5 or burst 1 then burst 3 or burst 1 then burst 5 or burst 5 then burst 3 or burst 5 then burst 1
                
                for traversing all cases (from 3(i) to 5(j))*/
                for(int k=i;k<=j;k++){
                    
                    /*we burst kth balloons at last in the range
                    e.g. we burst 3 means we alreay burst before that and after that balloons in the range
                    
                    this is the before that ballons
                    if k is at the starting position of range means we don't have left side otherwise take left side*/
                    int left = ( k==i ? 0 : dp[i][k-1] );
                    
                    /*we burst 3 means we already burst after that ballons i.e.15
                    so the answer in after the kth to jth -> 15 (we burst 1 at that position so we got it's left value*that value*it's right value)*/
                    int right = ( k==j ? 0 : dp[k+1][j] );
                    
                    /*now we burst the kth ballon
                    remember we bursted the left and right side ballons in the range
                    so we have to take points outside the range
                    meantion in question we get the point (left*kth*right)
                    as we bursted left and right ballons in the range so left and right ballons become close to kth
                    left ballon outside the range is i-1th
                    right ballon outside the range is j+1th*/
                    int value = ( i==0 ? 1 : nums[i-1] ) * nums[k] * ( j==n-1 ? 1 : nums[j+1] );
                    
                    int sum=left+right+value;
                    
                    dp[i][j]=Math.max(dp[i][j],sum);
                }
                
            }
        }
        
        for(int i[]:dp){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
        
        return dp[0][n-1];
    }
}
