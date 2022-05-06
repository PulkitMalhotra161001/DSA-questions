public void solveSudoku(char[][] board) {
        char temp[][]=new char[9][9];
        //copy board
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                temp[i][j]=board[i][j];
            }
        }
        //solve temp and change in board
        sudoku(temp,0,0,board);
    }
    public void sudoku(char a[][],int i,int j, char board[][]){
        //if i==9 i.e. 0 to 8 rows solved means is it solved
        if(i==a.length){
            //change temp to board and return
            for(int ii=0;ii<board.length;ii++){
                for(int jj=0;jj<9;jj++){
                    board[ii][jj]=a[ii][jj];
                }
            }
            return;
        }
        int ni=0,nj=0;
        //j==8 means last cols now the next row will be i+1 and start i.e. j=0
        if(j==8){
            ni=i+1;
            nj=0;
        }
        else{
            //search for the next col, same row, next element
            ni=i;
            nj=j+1;
        }
        //if already some value present means we can't change and move to next indexies
        if(a[i][j]!='.'){
            sudoku(a,ni,nj,board);
        }else{
            //try for 1 to 9 char/int
            for(char temp='1';temp<='9';temp++){
                //is it safe to place here means no temp ele in same row,col or 3*3 grid
                if(issafe(a,i,j,temp)){
                    //safe mean we can put temp here
                    a[i][j]=temp;
                    //solve for the next indexies
                    sudoku(a,ni,nj,board);
                    //means we put the wrong value and grid can't be solved with remaining characters/int so we need to put blank again and try again
                    a[i][j]='.';
                }
            }
        }
    }
    public boolean issafe(char a[][],int i,int j, char temp){
        for(int jj=0;jj<9;jj++){
            if(a[i][jj]==temp || a[jj][j]==temp || a[3*(i/3)+jj/3][3*(j/3)+jj%3]==temp)
                return false;
            //find if such ele/int in same col
            //find if such ele/int in same row
            //find if such ele/int in 3*3 grid
            //if we find char anywhere in such indies means char present and we can't put char here so we try with the different ele/int
        }
        // for(int ii=0;ii<9;ii++){
        //     if(a[ii][j]==temp)
        //         return false;
        // }
        // int si=i/3*3;
        // int sj=j/3*3;
        // this is for 3*3 grid
        // for(int ii=0;ii<3;ii++){
        //     for(int jj=0;jj<3;jj++){
        //         if(a[ii+si][jj+sj]==temp)
        //             return false;
        //     }
        // }
        return true;
    }
