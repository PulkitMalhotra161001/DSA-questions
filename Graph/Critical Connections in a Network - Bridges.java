class Solution {
    int low[];
    int time[];
    int t=0;
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> adj) {
        low=new int[n];
        time=new int[n];
        Arrays.fill(low,Integer.MAX_VALUE);
        
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(List<Integer> i:adj){
            list.get(i.get(0)).add(i.get(1));
            list.get(i.get(1)).add(i.get(0));
        }
        
        
        dfs(0,list,-1);
        
        for(int i:time){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:low){
            System.out.print(i+" ");
        }
        System.out.println();
        
        return ans;
    }
    public void dfs(int node, List<List<Integer>> adj, int ignore){
        time[node]=low[node]=t++;
        for(Integer nbr:adj.get(node)){
            if(nbr==ignore){
                continue;
            }
            if(low[nbr]==Integer.MAX_VALUE){
                dfs(nbr,adj,node);
            }
            low[node]=Math.min(low[nbr],low[node]);
            
            if(low[nbr]>time[node]){
                ans.add(Arrays.asList(node,nbr));
            }
        }
    }
}
