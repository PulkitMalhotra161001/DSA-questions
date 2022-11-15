// https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    //eg. 2,1,5,6,2,3
    public int largestRectangleArea(int[] h) {
        int ls[]=left_smallest(h);
        int rs[]=right_smallest(h);
        
        int max=0;
        for(int i=0;i<h.length;i++){
            //find width
            //max area that an ele cover
            //e.g. at index 4
            //left smallest is 1
            //right is height. i.e. 6
            //so width 6-1=5 and we subtract 1
            int cur_area=(rs[i]-ls[i]-1)*h[i];
            max=Math.max(max,cur_area);
        }
        return max;
        
    }
    
    //-1,-1,1,2,1,4
    //getting previous small values
    public int[] left_smallest(int h[]){
        int ls[]=new int[h.length];
        Deque<Integer> lss=new ArrayDeque<>();
        //first we have nothing short than 1st so store index -1
        ls[0]=-1;
        lss.add(0);
        
        for(int i=1;i<h.length;i++){
            //if current ele is bigger then pop that out and find smallest
            while(!lss.isEmpty() && h[lss.peek()]>=h[i]){
                lss.pop();
            }
            //means its the smallest in entire array
            if(lss.isEmpty())
                ls[i]=-1;
            //means some ele is smallest so store
            else
                ls[i]=lss.peek();
            lss.push(i);
        }
        return ls;
    }
    
    //1,6,4,4,6,6
    //same as left to right movement
    //here we are moving form right to left
    public int[] right_smallest(int h[]){
        int rs[]=new int[h.length];
        Deque<Integer> rss=new ArrayDeque<>();
        rss.add(h.length-1);
        rs[h.length-1]=h.length;
        for(int i=h.length-2;i>=0;i--){
            while(!rss.isEmpty() && h[rss.peek()]>=h[i])
                rss.pop();
            if(rss.isEmpty())
                rs[i]=h.length;
            else
                rs[i]=rss.peek();
            rss.push(i);
        }
        return rs;
    }
}

_______________________________________________________________________________________________________________________________________________________________
// one pass approach

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int max = 0;
        
        // monotonic stack => incr/decr order values
        // in this case increasing order values
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<=n;i++){
            
            // one !st.isEmpty() loop is also required for
            // i==n for last values if all's are increasing
            // then this loop also run to find max
            while(!st.isEmpty() && ( i==n || heights[st.peek()]>=heights[i]) ){
                
                int h = heights[st.pop()];
                int w = 0;
                
                if(st.isEmpty())    w = i ;
                else    w = i - st.peek() - 1 ;
                
                max = Math.max( max, h*w );
                
            }
            
            st.push(i);
            
        }
        
        return max;
        
    }
}
