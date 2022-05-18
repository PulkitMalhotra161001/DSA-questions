Java

class Solution
{
    int ans=0;
    public int possible_paths(int[][] edges, int n, int s, int d)
    {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i[]:edges){
            list.get(i[0]).add(i[1]);
            //undirected graph
            //list.get(i[1]).add(i[0]);
        }
        dfs(list,s,d,new boolean[n]);
        return ans;
    }
    private void dfs(List<List<Integer>> list,int s,int d,boolean vis[]){
        if(s==d){
            ans++;
            return;
        }
        vis[s]=true;
        for(Integer nbr:list.get(s)){
            if(!vis[nbr]){
                dfs(list,nbr,d,vis);
            }
        }
        //backtracking
        //there can be another way through this vertex (also possible)
        //this can be helpful in future (so we have to unmark)
        vis[s]=false;
    }
}
