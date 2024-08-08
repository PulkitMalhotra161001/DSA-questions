// 164. Maximum Gap

// https://leetcode.com/problems/maximum-gap/discuss/1240543/Python-Bucket-sort-explained
// https://www.geeksforgeeks.org/maximum-adjacent-difference-array-sorted-form/
class Solution {
    
    public int maximumGap(int[] nums) {
        
        //bucket sort
        
        int lo = Arrays.stream(nums).min().getAsInt();
        int hi = Arrays.stream(nums).max().getAsInt();
        
        int n = nums.length;
        if(n==1 || hi==lo)    return 0;
        int min[] = new int[n];
        int max[] = new int[n];
        
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        
        for(int x:nums){
            
            int id = (int)((x - lo+0l) * (n - 1)/ (hi - lo));
            
            //add current value into idth index bucket
            //we don't need all elements we are only interested in min and max value
            
            min[id] = Math.min(min[id], x);
            max[id] = Math.max(max[id], x);
            
        }
        
        int ans=0;
        int prevMax = lo;
        
        for(int i=0;i<n;i++){
            if(min[i]==Integer.MAX_VALUE)   continue;
            
            ans = Math.max(ans, min[i]-prevMax);
            
            prevMax=max[i];
        }
        
        return ans;
    }
}
