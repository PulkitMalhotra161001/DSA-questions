//edge and -edge

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            list.add(temp);
        }
        for(int i[]:connections){
//                  from        to
            list.get(i[0]).add(i[1]);
//             edge is positive means we need to reverse i.e. ans+=1
            list.get(i[1]).add(-i[0]);
        }
        // System.out.print(list);
        return dfs(list,new boolean[n],0);
    }
    
    public int dfs(List<List<Integer>> list,boolean vis[],int start){
//      so that we never come to this vertex again
        vis[start]=true;
        int ans=0;
        for(Integer nbr:list.get(start)){
//          not traversed neighbour
            if(!vis[Math.abs(nbr)]){
//                                                edge is positive we need to reverse
                ans+=dfs(list,vis,Math.abs(nbr))+ (nbr>0?1:0);
            }
        }
        return ans;
    }
    
}
