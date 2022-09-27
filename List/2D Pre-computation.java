// https://practice.geeksforgeeks.org/problems/queries-on-a-matrix0443/1

public int[][] solveQueries(int n, int[][] Queries) {
        int ans[][]=new int[n][n];
        for(int q[]:Queries){
            int x=q[0], y=q[1], x2=q[2], y2=q[3];
            
            // pre-computation
            
            // start from here
            
            ans[x][y]++;
            
            // marking last row
            if(x2+1<n){
                ans[x2+1][y]--;
            }
            
            // marking last column
            if(y2+1<n){
                ans[x][y2+1]--;
            }
            
            // marking last column ending index
            if(x2+1<n && y2+1<n){
                ans[x2+1][y2+1]++;
            }
            
            // print(ans);
        }
        
        // filling up rows
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j]+=ans[i][j-1];
            }
        }
        
        // filling up columns
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                ans[i][j]+=ans[i-1][j];
            }
        }
        return ans;
    }
    
    void print(int a[][]){
        for(int i[]:a){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
