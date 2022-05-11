
class Solution
{
    // we have to find "yaha/is node tak pauchne me kitna distance/wgt lagega"
    
    // valued stored liked
    // index=0  [[1,1],[2,6]] 0->1 wgt=1, 0->2 wgt=6
    // index=1  [[0,1],[2,3]] 1->0 wgt=1, 1->2 wgt=3
    // index=2  [[0,6],[1,3]] 2->0 wgt=6, 2->1 wgt=3
    
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
            int pop=pq.remove();
            
            //get all joined adjacents (vertice,distance)
            for(ArrayList<Integer> nbr_edge : adj.get(pop)){
                int vtx = nbr_edge.get(0);
                int dist = nbr_edge.get(1)/*wgt*/ + ans[pop];
                if(ans[vtx]>dist){
                    ans[vtx]=dist;
                    pq.add(vtx);
                }
            }
        }
        return ans;
    }
}

//this will not work for -ve edge
//for that we have Bellman–Ford Algorithm
