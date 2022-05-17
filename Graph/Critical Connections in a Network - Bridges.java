class Solution {
    //for maintaing the lowest possible value to connect
    int low[];
    //for maintaing the timer value
    int time[];
    //timer increase whenever we go to new node
    int t=0;
    //our answer
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> adj) {
        low=new int[n];
        time=new int[n];
        //default value of low is max (bcz we have to fill minimum value)
        Arrays.fill(low,Integer.MAX_VALUE);
        
        //just maintain the adjacency list
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(List<Integer> i:adj){
            list.get(i.get(0)).add(i.get(1));
            list.get(i.get(1)).add(i.get(0));
        }
        
        //do dfs traversal parent become -1 (imaginary node)
        dfs(0,list,-1);
        
//         for(int i:time){
//             System.out.print(i+" ");
//         }
//         System.out.println();
//         for(int i:low){
//             System.out.print(i+" ");
//         }
//         System.out.println();
        
        return ans;
    }
    
    public void dfs(int node, List<List<Integer>> adj, int ignore){
        //initailly fill the same timer value in both arrays
        time[node]=low[node]=t++;
        
        //traverse it's neighbours
        for(Integer nbr:adj.get(node)){
            
            //if nbr is parent node (then just ignore - otherwise if take minimum from parent that doesn't make sense for whole graph)
            if(nbr==ignore){
                continue;
            }
            
            //if neighbour node is unvisited then visit them
            if(low[nbr]==Integer.MAX_VALUE){
                //parent/ignore node parameter become the current node
                dfs(nbr,adj,node);
            }
            
            //if there is a back-edge or another short way to reach the node then fill up the value
            low[node]=Math.min(low[nbr],low[node]);
            
            //if there is no other way to reach this neighbour node that this neighbour node must have the heighter value than the parent timer
            if(low[nbr]>time[node]){
                //no other way to reach this neighbour node (means this edge is essential to connect graph - from parent vertex to neighbour vertex)
                ans.add(Arrays.asList(node,nbr));
            }
        }
    }
    
}
