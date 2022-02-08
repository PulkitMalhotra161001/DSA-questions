//shortest distance in a maze
class Solution {
    public class path{
        int x;
        int y;
        int steps;
        public path(int x,int y, int steps){
            this.x=x;
            this.y=y;
            this.steps=steps;
        }
    }
    //class to take indices and save steps taken
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
            return -1; // unvalid value
        
        int moves[][]={{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
                        //moves 8 directionally
        
        Queue<path> q=new LinkedList<>();
        q.add(new path(0,0,1)); 
        // queue for bfs for shortest distance i.e. one step taken at a time, class for storing steps
        while(!q.isEmpty()){
            path temp=q.poll();
            // start from current/adjacent indices
            int x=temp.x;
            int y=temp.y;
            if(x==n-1 && y==n-1)
                return temp.steps;
            //reached the destination
            grid[x][y]=1;
            for(int i=0;i<8;i++){
                int new_x=x+moves[i][0];
                int new_y=y+moves[i][1];
                if(new_x>=0 && new_x<n && new_y>=0 && new_y<n && grid[new_x][new_y]==0){
                    if(new_x==m-1 && new_y==n-1){
                        return curr.steps+1;
                    }
                    // make queue to add adjacent indices & steps taken
                    // from current so we can make move/step from adjacents
                    q.add(new path(new_x,new_y,temp.steps+1));
                    // take one step from current adjacent and save steps taken
                    grid[new_x][new_y]=1;
                    //not move back once travelled i.e. no need
                }
            }
        }
        return -1;
        
    }
    
}
