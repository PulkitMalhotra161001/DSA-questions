class Solution {
    
    //keep in mind this is just a small part of a problem
    //we are having only one word which we have to find
    //if it can be placed inside board or not(not returing grid after filling the word)

    public boolean placeWordInCrossword(char[][] board, String word) {
    
        //iterate in the board
        for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
        
                //check if character and space present only then go to inside if
				if(board[i][j]!='#') {
                
                    //can we put this word downward,rightward,upward,leftward
                    //sequence doesn't matter we are just checking
                    //if we find anywhere
                    //means we can fit this word somewhere in the board.
                    //So, return true
					if(canputdown(board,word,i,j))  return true;
					if(canputright(board,word,i,j)) return true;
                    if(canputup(board,word,i,j))    return true;
                    
                    if(canputleft(board,word,i,j))  return true;
				}
			}
		}
        
        //there is no such place where we can put this word in the grid
        return false;
    }
    
    
	private static boolean canputright(char[][] a, String word, int i, int j) {
        
        //we are going rightward
        //we have 2 cases where word can be fitted
        //if we have don't have left side or we have #
        //means we can't fill the word in front of any word and after spaces
		//now we know the conditions so we have to inverse it
        //means we have left space and there # not present (if that make sense)
        if(j-1>=0 && a[i][j-1]!='#')
			return false;
    
        //same goes for after the word
        //we have nothing or # present
        //so we inversed. We have after (adding the length of word) space left
        //means we have to # after that. if both contions fail then we can't put word here
		
        else if(j+word.length()<=a[0].length-1 && a[i][j+word.length()]!='#')
			return false;
		
        //now we are sure we can put word here
		for(int jj=0;jj<word.length();jj++) {
            //look bottom condition first
            //if we are checking values and all values matched or we are having long string which can't place here
		
            if(j+jj>a[0].length-1)
				return false;
            //if we have space means we can put word here
            //or we have element present which is same as index of our word element means we can put here
            //here jj is used to moving leftward direction
			//and i and j are index from where we are checking
            
            if(a[i][j+jj]==' ' || word.charAt(jj)==a[i][j+jj]) {
				continue;
			}
			
            else
                //if we don't have space means we have to same word but we have not
                //so we can't place word here
				return false;
		}
        
        //everything works fine so we can place word here
		return true;
	}
    
    
	//same as canputright method
	private static boolean canputdown(char[][] a, String word, int i, int j) {
	
        //checking for downward direction
        //so, if present area present(inside the box) so it should be #
        //and it is not so we return false
        if(i-1>=0 && a[i-1][j]!='#')
			return false;
        
        //same goes for this, checking after (adding the word/string length)
		else if(i+word.length()<=a.length-1 && a[i+word.length()][j]!='#')
			return false;
		
        for(int ii=0;ii<word.length();ii++) {
			if(i+ii>a.length-1)
				return false;
        
            //same as the previous one
            //here ii is used for going downward direction
			if(a[i+ii][j]==' ' || word.charAt(ii)==a[i+ii][j]) {
				continue;
			}
			
            else
				return false;
		}
        
        //everything works fine
		return true;
		
	}
    
    
    //here comes the fun part
    private static boolean canputleft(char[][] a, String word, int i, int j) {
	
        //going left so we don't have to right index if we have it must be #
        //if both condition fails means somthing other than # is present or index(i,j) is not the last the last index of grid
        if(j+1<=a[0].length-1 && a[i][j+1]!='#')
			return false;
        
        //checking if string can be fit here
        //keep in mind we are going right hand to left hand side
		else if(j-word.length()>=0 && a[i][j-word.length()]!='#')
			return false;
		
        for(int jj=0;jj<word.length();jj++) {
			//i think you got this part already
            //yes! we are out of the grid if this is the case means we are having long string that can't be places here
        
            if(j-jj<0)
				return false;
			if(a[i][j-jj]==' ' || word.charAt(jj)==a[i][j-jj]) {
				continue;
			}
			else
				return false;
		}
		return true;
		
	}
    
    
    // just going opposite direction of bottom
    private static boolean canputup(char[][] a, String word, int i, int j) {
	
        if(i+1<=a.length-1 && a[i+1][j]!='#')
			return false;
		
        else if(i-word.length()>=0 && a[i-word.length()][j]!='#')
			return false;
		
        for(int ii=0;ii<word.length();ii++) {
			if(i-ii<0)
				return false;
			if(a[i-ii][j]==' ' || word.charAt(ii)==a[i-ii][j]) {
				continue;
			}
			else
				return false;
		}
		return true;
		
	}
    
    //if you are reading this
    //try it by using array named as directions
    //left 0,-1
    //down 1,0
    //instead of similar 4 methonds
}
