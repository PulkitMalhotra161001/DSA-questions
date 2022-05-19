/*Kosaraju Algorithm
Strongly connected components in a graph

Concept -
Strongly connected means when take a node, now can we reach to all other vertices from that
if yes, then it is strongly connected
when we find any node from that we can't reach to all other vertices then this is not a Strongly connected graph
Strongly connected component is a subgraph that are themself strongly connected

Property 1: when a strongly connected component reverved(SCC) it still a SCC */

class Solution
{
    Stack<Integer> tSort=new Stack<>();
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        
        /* Step 1 : simple dfs and store into stack
        traverse to all it's components
        System.out.println(adj);
        traveral to all vertices in graph*/
        
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,vis,true);
            }
        }
        
        /*Step 2 : Reverse or transpose a graph
        SCC remains SCC
        inBrief: SCC1 connects to -> SCC2 (edge is reversed)*/
        
        ArrayList<ArrayList<Integer>> transpose=new ArrayList<>();
        for(int i=0;i<V;i++){
            transpose.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(Integer j:adj.get(i)){
                transpose.get(j).add(i);
            }
        }
        
        
        /*Step 3 : again dfs but take vertex from stack (if unvisited)
        If st.pop() is visited means we have traversed to all it's SCC
        do this for all vertcies ( bcz stack store all vertices )*/
        
        vis=new boolean[V];
        int ans=0;
        while(!tSort.isEmpty()){
            int pop=tSort.pop();
            if(!vis[pop]){
                ans++;
                dfs(transpose,pop,vis,false);
            }
        }
        return ans;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int start,boolean vis[],boolean first_dfs){
        vis[start]=true;
        for(Integer nbr:adj.get(start)){
            if(!vis[nbr]){
                dfs(adj,nbr,vis,first_dfs);
            }
        }
        if(first_dfs)
            tSort.push(start);
    }
}

/*Limitations :-
it do 2 dfs
it doesn't tell what are those components

    =>  For that we have Tarjans's Algo

Time Complexity => O( V + E)  -   DFS
Space Complexity => O( V + E)  -   Transpose
*/
