class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        
        
        // storing the in degree means u->v (v in degree will increase) (vertex are in)
        int in_degree[]=new int[V];
        
        for(ArrayList<Integer> i:adj){
            for(Integer j:i){
                in_degree[j]++;
            }
        }
        
        
        // store value who doesn't depend on any other vertex
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(in_degree[i]==0){
                q.add(i);
            }
        }
        
        
        int ans[]=new int[V];
        int i=0;
        
        
        while(!q.isEmpty()){
            // poll is faster then remove
            int u=q.poll();
            
            // this node doesn't depend on any other node
            ans[i++]=u;
            
            for(Integer v:adj.get(u)){
                // u vertex is removed
                // now all it's dependents will be disconnected from it
                // means between them vertex is removed
                // so as there in (degree) will also decrease
                in_degree[v]--;
                
                
                // if now this node is doesn't depend on any other node
                // this will be the next
                if(in_degree[v]==0){
                    q.add(v);
                }
                
            }
            
        }
        
        return ans;
    }
}

// eg. 1->0, 2->0, 3->0
// ans[] = 1 2 3 0
