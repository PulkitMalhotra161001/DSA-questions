//binary

class Solution {
    public int findMaxLength(int[] nums) {
        //youtube.com/watch?v=1WugaISSWx8
        
        //treat -1 as 1
        //total test cases length+1
        //if length is 1 then either value 1 or 0
        int n=nums.length;
        int values[]=new int[n*2+1];
        //we can fill any value
        Arrays.fill(values,-2);
        
        values[n]=-1;
        int count=0, ans=0;
        for(int i=0;i<n;i++){
            
            count+=nums[i]==0?-1:1;
            // if(nums[i]==0)
            //     count--;
            // else
            //     count++;
            if(values[count+n]==-2){
                //if none value present, never encounterd this sum before then save the index
                //sum can be -1 bcz we treat 0 as -1 so we are adding length
                values[count+n]=i;
            }
            else{
                //encoutered this sum before then index this previous sum index is may be our ans
                ans=Math.max(ans,i-values[count+n]);
            }
        }
        return ans;
        
    }
}
