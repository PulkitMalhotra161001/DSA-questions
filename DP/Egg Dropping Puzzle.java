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

            //maximum will be the no. of floors
            int max=j;

            //check if egg break or survive at this level
            //we are checking it for every time because floor and egg change
            for(int t=1;t<=j;t++){

                //egg break so no of eggs left egg-1 and floor left this floor upto ground
                int egg_break=   1+dp[i-1][t-1];

                //egg survived means break point not reached
                int egg_survived=1+dp[i][j-t];

                //take max (employee worst time vs best time)
                //we assume luck is not in our favour
                int ans=Math.max(egg_break,egg_survived);

                //take min from worst cases (best time we are sure of)
                max=Math.min(max,ans);
            }

            //fill result in dp (for this much of floors & this much eggs)
            dp[i][j]=max;
        }
    }
    return dp[n][k];
}
