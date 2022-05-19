// Prerequisite =>  Cut Edge - Bridges, Cut Vertex - Articulation Point

//it can tell how many SCC in a graph and what are those

class Solution{
    
    //tells at what time vertex is discovered
    int disc[];
    
    //what are the lowest value
    //initially both are same but if there is a short edge (back edge) then low will have the lowest value
    int low[];
    
    //just for knowing if vertex is +nst in recursive stack
    boolean stack_member[];
    
    //for what vertex we are traversing dfs
    Stack<Integer> stack=new Stack<>();
    
    //this is the timer when we come to a vertex
    //whenever we go the vertex we increase timer for another vertex
    int timer=0;
    
    //at what index we add the value
    //not very much important (bcz we can create new list and add elements in it)
    int index=0;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) {
        
        disc=new int[V];
        low=new int[V];
        stack_member=new boolean[V];
        //for unvisited vertex
        Arrays.fill(disc,-1);
        
        
        //do dfs for every vertex
        for(int i=0;i<V;i++){
            if(disc[i]==-1){
                dfs(adj,i);
            }
        }
        
        //Questions asked we have to return ans in ascending order
        for(int i=0;i<ans.size();i++){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans,(o1,o2)->o1.get(0)-o2.get(0));
        return ans;
    }
    
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int src){
        
        /*filled the value
        disc time is the discovery time
        for timer it is just default value*/
        low[src]=disc[src]=timer++;

        //this is the vertex we are travering to other vertex
        stack.push(src);

        //now this is a member of stack
        stack_member[src]=true;

        //traverse it's neighbours
        for(Integer nbr:adj.get(src)){
            
            //if unvisited then visit the neighbours
            if(disc[nbr]==-1){
                dfs(adj,nbr);
                
                /*and take the minimum from it's neighbour
                bcz if there is an edge then the neighbour contains the shortest path*/
                low[src]=Math.min(low[src],low[nbr]);
            }else{
                
                /*if neighbour vertex is visited then there are 2 cases
                whether the visited neighbour is an backedge
                or edge is an cross edge
                
                if vertex is a backedge then the stack member nbr is true
                bcz we calling recursive stack and mark the vertices in stack member*/
                
                if(stack_member[nbr]){
                    
                    //back-edge
                    low[src]=Math.min(low[src],disc[nbr]);
                }
                
                /*if there is a cross edge then we do nothing
                bcz imagine we have graph like SCC1<-SCC2
                now there is an cross edge (we are in SCC2)
                if we take low value and fill in source then the lowest value will be filled in entire SCC2
                and then the whole component will be only 1 SCC which is not true*/
            }
        }
        
        //means this the head of SCC
        if(disc[src]==low[src]){
            
            //prepare the SCC
            ans.add(new ArrayList<>());
            
            /*we can't just pop element from stack and compare
            bcz if there is only one vertex in a component
            then they both are equal and not go inside
            which is false this is SCC with only 1 vertex
            so we have to compare inside while*/
            while(true){
                
                //this value is part of SCC
                int pop=stack.pop();
                
                //add it into list
                ans.get(index).add(pop);
                
                //mark unvisited bcz this vertex can be a way for other SCC
                stack_member[pop]=false;
                
                //both become equal means this is head node of SCC
                if(pop==src)    break;
            }
            
            //for next position in list
            index++;
        }
    }
}
