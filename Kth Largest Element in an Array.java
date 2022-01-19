class Solution {
    public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> p=new PriorityQueue<>();
//         for(int i=0;i<nums.length;i++){
//             if(i<k)
//                 p.add(nums[i]);
//             else{
//                 if(nums[i]>p.peek()){
//                     p.remove();
//                     p.add(nums[i]);
//                 }
//             }
//         }
//         return p.peek();

//        PriorityQueue<Integer> p=new PriorityQueue<>();
//        for(int i:nums){
//            if(p.size()<k || p.peek()<i){
//                if(k==p.size())
//                    p.remove();
//                p.add(i);
//            }
//        }
//        return p.peek();}
        
        Arrays.sort(nums);
        return nums[nums.length-k];
        
    }
}
