public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,cur_sum=0;
        //Kaden's Algo
        for(int i=0;i<nums.length;i++){
            cur_sum+=nums[i];
            if(cur_sum>max){
                max=cur_sum;
            }
            if(cur_sum<0)
                cur_sum=0;
            
        }
        
        return max;
}
