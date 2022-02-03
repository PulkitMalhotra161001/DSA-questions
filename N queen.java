class Solution {
    //dp
    
    boolean neg_dia[]; // negative diagonal
    boolean pos_dia[]; // positive diagoanl
    boolean col[]; //column
    //we are not taking array for rows because when we place a queen we just increment our i to go to next row
    
    public List<List<String>> solveNQueens(int n) {
        neg_dia=new boolean[2*n-1]; //if we observe going right down diagoanl ↗️ keep r-col same
        pos_dia=new boolean[2*n-1]; //while going right upside diagonal ↘️ keeps, r+col same
        col=new boolean[n];
        //if any of this position already filled means we can't place queen here
        
        char board[][]=new char[n][n];
        //filling blank board
        
        for(char[] i:board)
            Arrays.fill(i,'.');
        
        List<List<String>> res=new ArrayList<>();        
        
        queen(board,0,res,n);
        
        return res;
    }
   
    private void queen(char board[][], int i,List<List<String>> ans,int n) {
        //if i go to the length means we have filled all the queen
		
        if(i==n) {
            //all queen placed successfully
            
            List<String> temp=new ArrayList<>();
            //now this is our ans
            
            for(int ii=0;ii<n;ii++){
                //this is our row we convert it to string eg. [.Q..] and we add this to an
                //other ans is also possible and we again come here and add it to our ans
                temp.add(String.valueOf(board[ii]));
            
            }
			
            ans.add(temp);
			
            return;
		}
		
        for(int j=0;j<n;j++) {
            
            //traversing int ith row with jth position
            //means checking where we can place queen at this row
            
            if(neg_dia[i-j+n-1] || pos_dia[i+j] || col[j])
                continue;
            
            //if any of this boolean true means we can't place queen here
            //col for column we can't place at this column
            //positive diagoanl for pos_dia we are having i+j
            //negative diagoanl for neg_dia we are having i-j+n-1
            //if we take i-j we have [-3,-2,-1,0,1,2,3] which is not a valid index for array
            //adding n-1 will convert [0,1,2,3,4,5,6]
            
            //queen placed here ( so true means we can't place other queen at any of this column, diagonally ) and check if we can place next queen in next row properly or not
            neg_dia[i-j+n-1]=true;
            pos_dia[i+j]=true;
            col[j]=true;

            //queen placed
            board[i][j]='Q';
            
            //checking for next row
            queen(board,i+1,ans,n);
            
            //means we placed queen at wrong location so we need to remove the queen
            board[i][j]='.';
            
            //after removing the queen we can place next queen at this loaction
            //nothing present at this time ( because we removed queen ) so we convert this position to false (no queen present)
        
            neg_dia[i-j+n-1]=false;
            pos_dia[i+j]=false;
            col[j]=false;
		
        }
        
	}
    
}

![Uploading WhatsApp Image 2022-02-03 at 10.22.47 AM.jpeg…]()

