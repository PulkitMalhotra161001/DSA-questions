class Solution {
    // -1 or +1 is just for index_out_of_bound cases
    public String longestPalindrome(String s) {
        
        //start is the starting index in string where mirror image starting
        //end is the ending index in string where mirror image end
        int start = 0, end = 0 ;
        
        for( int i=0; i<s.length(); i++ ){
            //palindrome is just mirror from center
            //there are total 2n-1 cases
            
            //for odd length string there will be center the center ele (n cases)
            int len1 = expand_in_middle( s, i, i );
            
            //for even length string there will be (n-1) points or we can say there will be two same char's as a center
            int len2 = expand_in_middle( s, i, i+1 );
            
            //we care about the max len
            int max_len = Math.max( len1, len2 );
            
            //if we found greater mirror image
            if( max_len > end-start ){
                
                //set start to the starting position of the mirror image
                
                //if we do max_len/2 if will work in odd length string but not in even length string so we have to subtract 1 from it
                start = i- ( max_len - 1 ) / 2;
                
                //set end to the ending position of the mirror image 
                end = i + max_len / 2;
            
            }
        
        }
        
        //start is pointing to the starting position
        //end is pointing to the ending position (but substring ignore end and gave end-1 length substring)
        return s.substring( start, end + 1 );
        
    }
    
    public int expand_in_middle(String s,int l,int r){
        
        //we are expanding from center
        //if we found same ele then we start expading
        while( l>=0 && r<s.length() && s.charAt(l)==s.charAt(r) ) {
            l--;
            r++;
        }
        
        
        //think like if we substract left from right we get our length but it is not final we have to subtract 1 to get our real ans
        
        //e.g how many days between 1 to 30
        //there will be 28
        //right - left = 29 but we have to find middle so we subtract 1
        return r-l-1;
    }
    
}
