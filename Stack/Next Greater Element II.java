//this is a stack problem but deque is faster than stack that's why we use this

//we have to return next greater element (at right - in cicular manner) for every position 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        //stack stores the ascending elements (if we look from top -> ofcourse)
        Deque<Integer> st=new ArrayDeque<>();
        
        //use as to duplicate values and make size *2 ( bcz we also have to go circular)
        //eg {1,2,1} => {1,2,1, 1,2,1}
        //as we don't have to create new array we can reference old by doubling the size (for cicular)
        for(int i=2*n-1;i>=0;i--){
            
            //while stack contains smaller elements
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
            }
            
            //use as a answer (if index is within limit then store the ans)
            if(i<n){
                ans[i%n]=st.isEmpty()?-1:st.peek();
            }
            
            //at last pushed the current element
            st.push(nums[i%n]);
            
        }
        
        return ans;
    }
}

// https://www.youtube.com/watch?v=Du881K7Jtk8
