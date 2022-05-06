// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1/#

//Prim's Algo
//take a random node (eg.0)
//add it's unvisited <node,weight> into PriorityQueue (pq)
//pq gave us minimum wgt node
//go to that node and repeat the process
//until all nodes becomes visited

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // System.out.print(adj);
        // [[[1, 5], [2, 1]], [[0, 5], [2, 3]], [[1, 3], [0, 1]]]
        //0 connect with 1 with weight 5
        boolean vis[] = new boolean[adj.size()];
        //we have to visit node only one time
        PriorityQueue<List<Integer>> q=new PriorityQueue<>((o1,o2)->o1.get(1)-o2.get(1));
        q.add(Arrays.asList(new Integer[]{0,0}));
        //sort according to weight
        int ans=0;
        while(!q.isEmpty()){
            List<Integer> pop=q.remove();
            //if current node is visited then skip
            if(vis[pop.get(0)]) continue;
            //add weight to the ans and mark node
            ans+=pop.get(1);
            vis[pop.get(0)]=true;
            //travel it's neighbours
            for(ArrayList<Integer> nbr:adj.get(pop.get(0))){
                //take only unvisited neighbours
                //and add in the pq
                if(!vis[nbr.get(0)]){
                    q.add(Arrays.asList(new Integer[]{nbr.get(0),nbr.get(1)}));
                }
            }
        }
        return ans;
    }
}

___________________________________________________________________________________________________________________________________________________________________

//Improvement 1:
//count the nodes
//ones count become no of nodes then break

___________________________________________________________________________________________________________________________________________________________________

//Improvement 2:
//since we need to take the node only one time
//so we can save it into an array

// https://leetcode.com/problems/min-cost-to-connect-all-points/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean vis[]=new boolean[n];
        int ans[]=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
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
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    int wgt = Math.abs(points[i][0]-points[node][0]) +
                              Math.abs(points[i][1]-points[node][1]);
                    ans[i]=Math.min(ans[i],wgt);
                }
            }
        }
        return res;
    }
}
