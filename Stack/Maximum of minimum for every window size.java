// https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1
class Solution 
{
    static int[] maxOfMin(int[] arr, int n) 
    {
        int ans[] = new int[n];
        
        int ls[]=new int[n];
        int rs[]=new int[n];
        Stack<Integer> st=new Stack<>();
        
        // getting left smallest element for all indecies
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[ st.peek() ]>= arr[i])   st.pop();
            ls[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        while(!st.isEmpty())    st.pop();
        
        // getting right smallest element for all indecies
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[ st.peek() ]>= arr[i])   st.pop();
            rs[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        // now we know arr[i] is min ele of a window length "right[i] - left[i] - 1".
        for(int i=0;i<n;i++){
            int wdo_len = rs[i]-ls[i]-1;
            // arr[wdo_len] has the maximum element for wdo_len size sliding windows
            // taking maximum's of same window sizes
            ans[wdo_len-1] = Math.max( ans[wdo_len-1], arr[i] );
        }


/*  Some entries in ans[] are 0 and yet to be filled.

    Below are few important observations to fill remaining entries
      
    1. Result for length i,
        i.e. ans[i] would always be greater or same as result for length i+1,
        i.e., ans[i+1]. 
        =>  bcz choti length ka max zyada hoga , badi len ka max km hoga
        => as we are taking minimum for sliding windows
        
    2. If ans[i] is not filled it means there is no direct element
        which is minimum of length i and therefore
        either the element of length ans[i+1], or ans[i+2], and so on is same as ans[i]
*/
        for(int i=n-1;i>0;i--){
            ans[i-1] = Math.max( ans[i-1], ans[i] );
        }
        
        return ans;
    }
}
