class Solution {
    class indexies{
        int x;
        int y;
        indexies(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<indexies> q=new LinkedList<>();
        int m=mat.length,n=mat[0].length;
        int ans[][]=new int[m][n];
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int[] i:ans)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new indexies(i,j));
                    ans[i][j]=0;
                }
            }
        }
        
        while(!q.isEmpty()){
            indexies temp=q.poll();
            int new_x;
            int new_y;
            for(int i=0;i<4;i++){
                new_x=temp.x+dir[i][0];
                new_y=temp.y+dir[i][1];
                if(new_x>=0 && new_y>=0 && new_x<m && new_y<n){
                    if(ans[new_x][new_y]>ans[temp.x][temp.y]+1){
                        ans[new_x][new_y]=ans[temp.x][temp.y]+1;
                        q.add(new indexies(new_x,new_y));
                    }
                }
            }
        }
        
        return ans;
    }
}

______________________________________________________________________________________________________________________________________________________________________________

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        int max = m*n;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    int up = (i==0)?max:dp[i-1][j]+1;
                    int left= (j==0)?max:dp[i][j-1]+1;
                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        
        for(int i=m-1; i>=0;i--){
            for(int j=n-1; j>=0; j--){
                if(mat[i][j] == 1){
                    int down = (i==m-1)?max:dp[i+1][j]+1;
                    int right= (j==n-1)?max:dp[i][j+1]+1;
                    dp[i][j] = Math.min(dp[i][j],Math.min(right, down));
                }
            }
        }
        
        return dp;
    }
}
