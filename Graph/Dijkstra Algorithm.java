// https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

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
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[]{S,0});
        
        while(!pq.isEmpty()){
            //getting minimum vertice from queue
            int rem[]=pq.remove();
            int pop=rem[0];
            // System.out.println(pop);
            
            //get all joined adjacents (vertice,distance)
            for(ArrayList<Integer> nbr_edge : adj.get(pop)){
                int vtx = nbr_edge.get(0);
                int dist = nbr_edge.get(1)/*wgt*/ + ans[pop];
                if(ans[vtx]>dist){
                    ans[vtx]=dist;
                    pq.add(new int[]{vtx,ans[vtx]});
                }
            }
            
        //     for(int i:ans)  System.out.print(i+" ");
        //     System.out.println();
        }
        return ans;
    }
}

//this will not work for -ve edge
//for that we have Bellman–Ford Algorithm


___________________________________________________________________________________________________________________________________________________________________




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

___________________________________________________________________________________________________________________________________________________________________


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean vis[]=new boolean[n];
        int ans[]=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[S]=0;
        int total=0;
        int res=0;
        while(total<n){
            int min=Integer.MAX_VALUE;
            int node=-1;
            for(int i=0;i<n;i++){
                if(!vis[i] && ans[i]<min){
                    min=ans[i];
                    node=i;
                }
            }
            vis[node]=true;
            total++;
            res+=min;
            for(ArrayList<Integer> i:adj.get(node)){
                if(!vis[i.get(0)]){
                    ans[i.get(0)]=Math.min(i.get(1)+ans[node],ans[i.get(0)]);
                }
            }
        }
        return ans;
    }
}
