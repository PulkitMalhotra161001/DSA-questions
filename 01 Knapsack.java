class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        //create dp array
        int dp[][]=new int[n+1][W+1];
        
        //for capacity 0 or non elements we have nothing to put or no capacity so 0
        
        //traverse
        for(int i=1;i<=n;i++){
            //j is our current capacity
            for(int j=1;j<=W;j++){
                
                //we have to take maximum items till now
                //but we are not able to pick this item
                //we picked the maximum ans which is available above this item
                int not_take=dp[i-1][j];
                int take=0;
                
                //check whether if we are able to pick this item
                //bag capacity is equal to or greater to weight
                if(j>=wt[i-1]){
                    
                    //we are able to pick this item
                    //and add remaining item in the bag
                    //which is available at the above list array
                    //at poisition (bag capaity - weight of this item)
                    
                    take=val[i-1] + dp[i-1][j-wt[i-1]];
                }
                
                //put the maximum value
                //if we pick this item
                //else we don't pick this item
                dp[i][j]=Math.max(not_take, take);
            
                
            }
        }
        
        //ans is avaible at the last position
        //bcz we take ans in all values
        //and fill up capacity as well
        return dp[n][W];
        
    } 
}
