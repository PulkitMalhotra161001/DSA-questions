//BFS
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Set<Integer>[][] rl=new HashSet[2][n];
        for(int i=0;i<n;i++){
            rl[0][i]=new HashSet<>();
            rl[1][i]=new HashSet<>();
        }
        for(int i[]:redEdges){
            rl[0][i[0]].add(i[1]);
        }
        for(int i[]:blueEdges){
            rl[1][i[0]].add(i[1]);
        }
        int ans[][]=new int[2][n];
        for(int i=0;i<n;i++){
            ans[0][i]=Integer.MAX_VALUE;
            ans[1][i]=Integer.MAX_VALUE;
        }
        ans[0][0]=0;
        ans[1][0]=0;
        Queue<int[]> q=new LinkedList<>();
        //index,color
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        int level=0;
        while(!q.isEmpty()){
            int pop[]=q.remove();
            int vtx=pop[0];
            int color=pop[1];
            for(Integer nbr:rl[color][vtx]){
                if(ans[1-color][nbr]==Integer.MAX_VALUE){
                    ans[1-color][nbr]=1+ans[color][vtx];
                    q.add(new int[]{nbr,1-color});
                }
            }
        }
        for(int i=0;i<n;i++){
            int temp=Math.min(ans[0][i],ans[1][i]);
            ans[0][i]=temp==Integer.MAX_VALUE?-1:temp;
        }
        return ans[0];
    }
}
