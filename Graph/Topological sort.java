
// Topological Sort
// u,v
// u comes before v for all edges
// there can be many possible answers

// it is only possible for Directed Acyclic Graph (DAG)
// if there is undirected then how comes u before v
// if there is cycle then there will be no solution e.g. 1->2, 2->3, 3->1

class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
        // stack to keep track for all u to v's
        // v come first then u (upon v)
        // first we go to the al nbr of the current vertex
        // now if nbr vertex is not going further then we push into stack (v)
        // then recurse back (u)
        // if we look closely we are adding (u) after reaching to all it's nbr's (v)
        // means pushing v then u
        Stack<Integer> st=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                //run a dfs
                dfs(adj,st,vis,i);
            }
        }
        
        // now we know u is upon v
        int ans[]=new int[V];
        int i=0;
        while(!st.isEmpty()){
            // first u comes out
            ans[i++]=st.pop();
        }
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean vis[],int start){
        
        // if we print now then the problem will be if any other node pointing to this vertex then those vertex should be print first
        // so this prefix approach will not work
        
        vis[start]=true;
        for(Integer nbr:adj.get(start)){
            // for to v
            // for all u to v's
            if(!vis[nbr]){
                dfs(adj,st,vis,nbr);
            }
        }
        // push v (we are on right now) then u
        st.push(start);
        
        
        // if we print now then the problem will be if any other node pointing to this vertex then those vertex should be print first
        // so this postfix approach will also not work
    }
}


// eg. 1->0, 2->0, 3->0
// ans[] = 3 2 1 0
