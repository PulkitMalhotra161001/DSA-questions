// https://practice.geeksforgeeks.org/problems/articulation-point2616/1/#

//is_Articulation_point means if this vertex is removed from graph
//It disconnects the graph into 2 or more components, or in other words, 
//removing vertex will increase the number of connected components.

class Solution
{
    //keeps track at what time this node is reached (after reaching a node timer++)
    int time[];
    
    //keep tracks of lower time if there is a back-edge/another short way then it is less than time otherwise same
    int low[];
    
    //keep tracks if a vertex is visited previously or not
    boolean vis[];
    
    //if we directly fill elements in a list then 
    //there can be a case that a vertex is filled more than one time in a list
    //So, for not containing duplicay we maintains an array
    boolean iap[]; //is_Articulation_point
    
    //time at what we reach a vertex (after we reached a unvisited vertex we ++)
    int timer=0;
    
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        
        time=new int[V];
        low=new int[V];
        vis=new boolean[V];
        iap=new boolean[V];
        
        // Given an undirected graph (not necessarily connected)
        // we have to check for unvisited vertices
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,-1,adj);        
            }
        }
        
        //just for ans
        List<Integer> ans1=new ArrayList<>();
        
        //traverse in is_Articulation_point
        for(int i=0;i<V;i++){
            
            //if this vertex is esential vertex
            if(iap[i]){
                //then add
                ans1.add(i);
            }
            
        }
        
        //we none vretex is essential
        //then ans be -1
        if(ans1.size()==0)  ans1.add(-1);
        
        //convert list to array
        int[] ans = ans1.stream().mapToInt(i -> i).toArray();
        
        return ans;
        
    }
    
    private void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj){
        
        //just filled the timer in both array (default)
        //if there is another short way then low will decrease
        time[node]=low[node]=timer++;
        
        //visit the node so we don't come again
        vis[node]=true;
        
        //this is an essential step
        //we have to check how many child does this node have
        //we visit/travere one child
        //if one child is connected to another child then another is already coverted by 1st child dfs
        //Conclusion : how many individual child does a node have
        int child=0;
        
        //traverse neighbours
        for(Integer nbr:adj.get(node)){
            
            //if neighbour is parent then just skip
            //otherwise neighbour will have to parent low time (which doesn't make any sense)
            if(nbr==parent) continue;
            
            //if neighbour is unvisited
            if(!vis[nbr]){
                
                //do traversal
                //parent become the current node (form which we are coming to neighbour node)
                dfs(nbr,node,adj);
                
                //this is an indivial child for this current node
                child++;
                
                //we traversed the future node or neighbours nodes
                //now we know if there is a back-edge or short edge
                //then future low decremented
                //so we have to do this alos
                low[node]=Math.min(low[node],low[nbr]);
                
                //if this is a essential edge
                // > low of neighbour(v) (which we updated) is greater than this node(u) discovery time  - (which have to be bcz we filled (bcz we ++ timer))
                // = neighbour takes lower time from this vertex (then they are equal)
                //means if we don't have this vertex the graph will break into upper half and lower half component
                //parent!=-1 if we remove root then the graph still be connected bcz there is no upper half componenet
                if(low[nbr]>=time[node] && parent!=-1){
                    iap[node]=true;
                }
            }else{
                
                //already visited vertex  take the lower value
                low[node]=Math.min(low[node],time[nbr]);
            }
        }

        //there can be a case that root node is essentail
        //like a tree (dfs of one child will not able to traverse other child)
        //if we remove root graph breaks into child portion (components)
        if(child>1 && parent==-1){
            iap[node]=true;
        }
        
    }
}
