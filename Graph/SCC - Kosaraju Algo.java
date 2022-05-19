// Kosaraju Algorithm
// Strongly connected components in a graph

// Concept -
// Strongly connected means when take a node, now can we reach to all other vertices from that
// if yes, then it is strongly connected
// when we find any node from that we can't reach to all other vertices then this is not a Strongly connected graph
// Strongly connected component is a subgraph that are themself strongly connected

// Property 1: when a strongly connected component reverved(SCC) it still a SCC 

class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        
        // Step 1 : simple dfs and store into stack
        // traverse to all it's components
        // System.out.println(adj);
        // traveral to all vertices in graph
        
        boolean vis[]=new boolean[V+1];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,vis,i,st);
            }
        }
        // System.out.println(st);
        
        // Step 2 : Reverse or transpose a graph
        // SCC remains SCC
        // inBrief: SCC1 connects to -> SCC2 (edge is reversed)
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
        for(int i=0;i<V;i++){
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                rev.get(adj.get(i).get(j)).add(i);            
            }
        }
        
        // Step 3 : again dfs but take vertex from stack (if unvisited)
        // If st.pop() is visited means we have traversed to all it's SCC
        // do this for all vertcies ( bcz stack store all vertices )
        
        // System.out.println(rev);
        vis=new boolean[V+1];
        int ans=0;
        while(!st.isEmpty()){
            int pop=st.pop();
            if(!vis[pop]){
                dfs(rev,vis,pop);
                ans++;
            }
        }
        
        // System.out.println();
        return ans;
    }
    
    void dfs(ArrayList<ArrayList<Integer>> al, boolean[] vis, int start){
        if(vis[start])  return;
        vis[start]=true;
        for(Integer nbr:al.get(start)){
            dfs(al,vis,nbr);
        }
    }
    
    void dfs(ArrayList<ArrayList<Integer>> al, boolean[] vis, int start,Stack<Integer> st){
        if(vis[start])  return;
        vis[start]=true;
        for(Integer nbr:al.get(start)){
            dfs(al,vis,nbr,st);
        }
        st.push(start);
    }
    
}

// Time Complexity => O( V + E)  -   DFS
// Space Complexity => O( V + E)  -   Transpose
