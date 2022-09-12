// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int x=0, count=0;
        for(int i:nums){
            if(count==0){
                x=i;
            }
            count+=(i==x) ? 1 : -1;
            
        }
        return x;
    }
}


// Extended Boyer Moore’s Voting Algorithm

// https://leetcode.com/problems/majority-element-ii/solution/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a=0, b=0, c1=0, c2=0;
        for(int i:nums){
            if(i==a){
                c1++;
            }else if(i==b){
                c2++;
            }else if(c1==0){
                a=i;
                c1=1;
            }else if(c2==0){
                b=i;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }
        
        
        c1=0;
        c2=0;
        for(int i:nums){
            if(i==a)    c1++;
            else if(i==b)   c2++;
        }
        
        List<Integer> ans=new ArrayList<>();
        if(c1>nums.length/3)    ans.add(a);
        if(c2>nums.length/3)    ans.add(b);
        
        return ans;
    }
}
