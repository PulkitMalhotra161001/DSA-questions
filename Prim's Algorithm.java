// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1/#
static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
{
    // Add your code here
    // System.out.print(adj);
    boolean vis[] = new boolean[adj.size()];
    PriorityQueue<List<Integer>> q=new PriorityQueue<>((o1,o2)->o1.get(1)-o2.get(1));
    q.add(Arrays.asList(new Integer[]{0,0}));
    int ans=0;
    while(!q.isEmpty()){
        List<Integer> pop=q.remove();
        if(vis[pop.get(0)]) continue;
        ans+=pop.get(1);
        vis[pop.get(0)]=true;
        for(ArrayList<Integer> nbr:adj.get(pop.get(0))){
            if(!vis[nbr.get(0)]){
                q.add(Arrays.asList(new Integer[]{nbr.get(0),nbr.get(1)}));
            }
        }
    }
    return ans;
}
