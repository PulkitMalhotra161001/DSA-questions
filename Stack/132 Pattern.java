// Monotonic Stack
// deque is faster than stack

// 132
// i < j < k
// nums[i] < nums[k] < nums[j]

// same as Next Greater Element II

class Solution {
    public boolean find132pattern(int[] nums) {
        
        Deque<Integer> third=new ArrayDeque<>();
//      second smallest element in array (while 132 not occur)
        int second=Integer.MIN_VALUE;
        
//      from last bcz we have to take 2 then 3   
        for(int i=nums.length-1;i>=0;i--){
            int cur=nums[i];

//          can this current element behave as a first ( in 132 )
//          means we already taken care about 3 while ( 3 > 2 )
//          now does 1<2 (we alredy know 3>2)
            if(cur<second){
                return true;
            }
            
//          now cur will not behaving like 1 
//          behave it like 3
//          remove all the smallest from stack as 2<3
            while(!third.isEmpty() && third.peek()<cur){
                second=third.pop();
//              second=Math.min(second,third.pop());
            }
            
//          now push the current element means 3
            third.push(cur);
        }
        
//      not be in the loop means not found values (either 1 or 2 or both)
        return false;
        
    }
}
