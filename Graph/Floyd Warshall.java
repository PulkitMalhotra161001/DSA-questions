//Aim  - We have to find the shortest path from every pair of vertex
//It can also detect -ve weightest cycle

//vertex to itself smallest distance is 0

//if after appling the shortest path (vertex to iteself shortest distance is -ve) means there is a -ve cycle

class Solution{
    public void shortest_distance(int[][] matrix){
    
        //we have given matrix of n*n
        //there is a wgt from i to j in it
        int n=matrix.length;
        
        //take route via k
        for(int k=0;k<n;k++){
            
            //for every vertex in a graph
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    //If value equal to k then that make no sense
                    //bcz we have 0(i)->2(j) via 0 or 2
                    //Or there is not effective path 
                    if(i==k || j==k || matrix[i][k]==-1 || matrix[k][j]==-1)    continue;
                    
                    //as we saw there is a value -ve, so in taking the minimum path it always take the -1
                    //so here we have to put maximum value
                    else if(matrix[i][j]==-1)   matrix[i][j] = Integer.MAX_VALUE;
	                
	                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }
}

___________________________________________________________________________________________________________________________________________________________

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges){
        
        int dp[][]=new int[n][n];
        
        //fill there is no path till now
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        
        //vertex to itself is 0
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        
        //traverse in edges and fill the weight in a 
        for(int i[]:edges){
            dp[i[0]][i[1]]=i[2];
        }
        
        //traverse via k
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    
                    //if value is itself then there is no path
                    //if there is no path further
                    if(i==k || j==k || dp[i][k]==-1 || dp[k][j]==-1)    continue;
                    
                    //as there is no path so there are -1 but we have to find minimum value
                    //so we stored max in here
                    else if(dp[i][j]==-1)   dp[i][j] = Integer.MAX_VALUE;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        //if vertex to itself is not 
        for(int i=0;i<n;i++){
            if(dp[i][i]!=0){
                //there is -ve cycle
                return 1;
            }
        }
        
        return 0;
    }
}
