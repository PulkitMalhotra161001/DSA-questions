//valued stored liked
    // index=0  [[1,1],[2,6]]
    // index=1  [[0,1],[2,3]]
    // index=2  [[0,6],[1,3]]
    
    //[[[1,1],[2,6]],[[0,1],[2,3]],[[0,6],[1,3]]]
        
        
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){

        //distance of all vertices from source
        int ans[]=new int[V];
        //we have to find minimum so put max
        Arrays.fill(ans, Integer.MAX_VALUE);
        //from source to source distance=0
        ans[S]=0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(S);
        
        while(!pq.isEmpty()){
            //getting minimum vertice from queue
            int temp=pq.remove();
            
            //get all joined adjacents (vertice,distance)
            ArrayList<ArrayList<Integer>> joined_vertices=adj.get(temp);
            for(int i=0;i<joined_vertices.size();i++){
                
                //get joined vertice value
                int adjacent_vertice=joined_vertices.get(i).get(0);
                //get joined vertice distance
                int adjacent_node_dist=joined_vertices.get(i).get(1)+ans[temp];
                //if we getting smaller distance from travelled vertice the update
                
                if(ans[adjacent_vertice]>adjacent_node_dist){
                    ans[adjacent_vertice]=adjacent_node_dist;
                    pq.add(adjacent_vertice);
                } 
            }
        }
        
        
        return ans;
    }
