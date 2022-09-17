// https://leetcode.com/problems/trapping-rain-water/

class Solution {

//     in this approach we are storing decreasing elemets in stack
//     if there's some value which is larger than stack peek means this will work as right pillar and we know stack contains decresing elemts (first pop elemets is where the water wil be get filled) and stack second peek will work as left pillar
    
    public int trap(int[] height) {
        int res=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<height.length;i++){
            while( st.size()>0 && height[i]>height[st.peek()] ){
                int fill_index=st.pop();
                if(st.isEmpty())    break;
                int length=i-st.peek()-1;
                int width=Math.min(height[st.peek()], height[i]) - height[fill_index];
                res+=length*width;
            }
            st.push(i);
        }
        return res;
    }
    
    
//     in the left and right max array's approach we are taking minimum from left[i] and right[i] than subtract height[i]
//     in this appraoch we are doing same but instead of taking minimum from left and right we already know which is lower

    // public int trap(int[] height) {
    //     int n=height.length, l=0, r=n-1, left_max=0, right_max=0, res=0;
    //     while(l<r){
//     we know left value is shorter
    //         if(height[l]<=height[r]){
//     if this is the maximum left value means water can't be stored here
    //             if(height[l]>=left_max)  left_max=height[l];
//     else we know there some left pillar which will help to store water
    //             else    res+=left_max-height[l];
    //             l++;
    //         }else{
    //             if(height[r]>=right_max) right_max=height[r];
    //             else    res+=right_max-height[r];
    //             r--;
    //         }
    //     }
    //     return res;
    // }

    
    // public int trap(int[] height) {
    //     int n=height.length;
    //     int left[]=new int[n];
    //     int right[]=new int[n];
    //     for(int i=0;i<n;i++){
    //         left[i]=i==0?height[i]:Math.max(left[i-1],height[i]);
    //     }
    //     for(int i=n-1;i>=0;i--){
    //         right[i]=i==n-1?height[i]:Math.max(right[i+1],height[i]);
    //     }
    //     int ans=0;
    //     for(int i=0;i<n;i++){
    //         ans+=Math.min(left[i],right[i])-height[i];
    //     }
    //     return ans;
    // }
}
