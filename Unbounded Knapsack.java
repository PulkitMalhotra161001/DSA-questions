//same as 01 Knapsack but we can select a value unlimited times

//Target sum subset       vs   coin change
//duplicacy not allowed   vs   duplicacy allowed
//2D                      vs   1D

//01 Knapsack             vs   Unbounded Knapsack
//2D                      vs   1D

static int knapSack(int N, int W, int val[], int wt[])
{
    // bag capacity
    int dp[]=new int[W+1];

    //for every bag capacity
    for(int i=1;i<=W;i++){

        //traveral all values in array
        for(int j=0;j<N;j++){

            //if bag capacity is greater than or equal to item weight
            //means we can pick
            if(i>=wt[j]){

                //we storing the maximum value
                //value of this item + remaining bag capacity weight value 
                dp[i]=Math.max(dp[i],val[j]+dp[i-wt[j]]);

            }
        }
        // System.out.print(dp[i]+" ");
    }
    // System.out.println();
    return dp[W];
}
