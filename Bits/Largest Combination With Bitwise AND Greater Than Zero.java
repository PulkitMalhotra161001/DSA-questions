// https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
class Solution {
    public int largestCombination(int[] candidates) {
        int ans=0;
        
        //check for all position in int (32 bit)
        for(int i=0;i<32;i++){
            
            //change position of set bit
            int bit=1<<i;
            
            //count the set bits
            int cur=0;
            
            for(int can:candidates){
                
                // if there is a set bit at position i
                // then there will be >0
                if((can&bit)>0){
                    cur++;
                }
                
            }
            ans=Math.max(ans,cur);
        
        }
        return ans;
    }
}
