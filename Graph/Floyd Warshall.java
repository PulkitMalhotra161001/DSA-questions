//Aim  - We have to find the shortest path from every pair of vertex

//vertex to itself smallest distance is 0

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
