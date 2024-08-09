static int eggDrop(int n, int k) 
{
    int dp[][]=new int[n+1][k+1];

    //1 egg (max floor)
    for(int j=0;j<=k;j++){
        dp[1][j]=j;
    }

    //1 floor (max 1 egg required)
    for(int i=0;i<=n;i++){
        dp[i][1]=1;
    }

    //fill dp
    for(int i=2;i<=n;i++){
        for(int j=2;j<=k;j++){

            //we have to take the best case in the worst_case scenarios (best of worst) (min of max)
            int min_attempt = Integer.MAX_VALUE;
            
            //drop the egg from every floor
            //take max from those (egg_break and egg_survive)
            //from all the possibilities take min (this ensure that our work is done)
            for(int t=1;t<=j;t++){

                //egg break so no of eggs left egg-1 and floor left this floor upto ground
                int egg_break = 1+dp[i-1][t-1];

                //egg survived means break point not reached
                int egg_survived = 1+dp[i][j-t];

                //eggs broke at the 'kth floor' (egg-1|k-1) or not (egg|total_floor-k)
                // take the worst case scenarios
                int current_attempt=Math.max(egg_break,egg_survived);

                //take min from worst cases (best time we are sure of)
                min_attempt=Math.min(min_attempt,current_attempt);
            }

            //fill result in dp (for this much of floors & this much eggs)
            //we have to take the best case in the worst_case scenarios (best of worst) (min of max)
            dp[i][j]=min_attempt;
        }
    }
    return dp[n][k];
}
