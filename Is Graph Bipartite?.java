//BFS

class Solution {
    
    //isBipartite means (u,v) u goes to set1 and v goes to set2, do this for all vertex
    //check whether it is possible or not
    //or we can say we have to color it with 2 different colors (0 and 1)
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        //we make an array
        //whehter this ele is visited or not
        //if yes then what level
        int dp[]=new int[n];
        
        //mark unvisited all nodes
        Arrays.fill(dp,-1);
        
        //check for all nodes bcz graph can be unconnected
        for(int i=0;i<n;i++){
            
            //if this node is not visited then do traversal
            if(dp[i]==-1){
                
                //if this says we can't do it means we can't color it with two differnt colors or put it into two differnt sets
                if(!bfs(graph,dp,i)){
                    return false;
                }
                
            }
        }
        
        return true;
        
    }
    
    public boolean bfs(int graph[][],int dp[],int start){
        
        //for BFS add the start node to queue and do traversal
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        
        //mark visisted
        dp[start]=0;
        
        while(!q.isEmpty()){
            
            int pop=q.remove();
            
            //visit it's neighbours
            for(int nbr:graph[pop]){
                
                //if nbr is not visited
                if(dp[nbr]==-1){
                    
                    //color it with differnt then pop (node) color (level)
                    //we fill 0 or 1
                    //if (pop=0; nbr=1)   else (pop=1; nbr=0)
                    dp[nbr]=1-dp[pop];
                    q.add(nbr);
                }else{
                    
                    //if this node is visited
                    //check if it's have same color or different
                    //if it has different color means we can skip it bcz we have to color it differntly
                    //else (it have same color) (we can't do it further)
                    if(dp[nbr]==dp[pop]){
                        return false;
                    }
                    
                }
            }
        }
        
        //everthing works fine
        //we can move onto next
        return true;
        
    }
}

_____________________________________________________________________________________________________________________________________________________________

//DFS

class Solution {
    
    //isBipartite means (u,v) u goes to set1 and v goes to set2, do this for all vertex
    //check whether it is possible or not
    
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        
        //we make an array
        //whehter this ele is visited or not
        //if yes then what level
        int dp[]=new int[n];
        
        //mark unvisited all nodes
        Arrays.fill(dp,-1);
        
        //check for all nodes bcz graph can be unconnected
        for(int i=0;i<n;i++){
            
            //if this node is not visited
            if(dp[i]==-1)
                
                //do traversal
                if(!dfs(graph,dp,i,0)){
                    return false;
                }
            
        }
        
        return true;
        
    }
    
    public boolean dfs(int graph[][],int dp[],int start,int color){
        
        //color it
        dp[start]=color;
        
        //and do traversal
        for(int nbr:graph[start]){
            
            //node is not visited
            if(dp[nbr]==-1){
                
                //color it differntly and do traversal
                dp[nbr]=1-color;
                
                //if we can't color it further then we just return
                if(!dfs(graph,dp,nbr,1-color)){
                    return false;
                }
                
                //already colored
            }else{
                
                //if colored it differntly then it's totally fine
                if(dp[nbr]==1-color){
                    
                }else{
                    //if colored with same color then we can't color it furhter
                    return false;
                }
            }
            
        }
        
        //everthing works fine
        //we can color it
        return true;
        
    }
}
