class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]){
        
        int ans=0,n=nums.length;
        int sorted_nums[]=nums.clone();
        
        // Hashmap which stores the
        // indexes of the input array
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        
        Arrays.sort(sorted_nums);
        
        for(int i=0;i<n;i++){
            
            // This is checking whether
            // the current element is
            // at the right place or not
            if(nums[i]!=sorted_nums[i]){
                
                int prev_ith_value=nums[i];
                
                // If not, swap this element
                // with the index of the
                // element which should come here
                swap(nums,i,map.get(sorted_nums[i]));
                
                // Update the indexes in
                // the hashmap accordingly
                map.put(prev_ith_value,map.get(sorted_nums[i]));
                map.put(nums[i],i);
                
                ans++;
            }
            
        }
        return ans;
    }
    
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
