//less space then segment tree
//less code required
// https://www.youtube.com/watch?v=9uaXG62Y8Uw (Striver)
// https://www.youtube.com/watch?v=uSFzHCZ4E-8 (Animated)


// https://leetcode.com/problems/count-good-triplets-in-an-array/
// https://www.youtube.com/watch?v=HZgwNLZg_-Y (Youtube Solution)
// https://leetcode.com/problems/count-good-triplets-in-an-array/discuss/1784036/Java-Solution-Using-Fenwick-Tree (Code Solution)
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int pos[]=new int[n];
        //positions of ith element in nums2 array
        for(int i=0;i<n;i++)    pos[nums2[i]]=i;
        
        FenwickTree ft=new FenwickTree(n+1);
        
        long left[]=new long[n];
        long right[]=new long[n];
        long ans=0;
        
        for(int i=0;i<n;i++){
            //index of current element in nums2 array
            int id = pos[nums1[i]];
            
            //find count of small element than id
            left[i] = ft.sum(id-1);
            
            //increase count by 1
            ft.update(id,1);
        }
        
        ft=new FenwickTree(n+1);
        
        for(int i=n-1;i>=0;i--){
            //index of current element in nums2 array
            int id = pos[nums1[i]];
            
            //find count of small element than id
            //total sum - get sum
            right[i] = ft.sum(n+1) - ft.sum(id);
            
            //increase count by 1
            ft.update(id,1);
        }
        
        
        
        for(int i=0;i<n;i++){
            ans+=left[i]*right[i];
        }
        return ans;
    }
}

class FenwickTree{
    int n;
    int ft[];
    FenwickTree(int n){
        this.n=n;
        ft=new int[n+2];
    }
    //get sum till i
    //log(N)
    int sum(int i){
        //1 based indexing
        i++;
        int ans=0;
        while(i>0){
            ans+=ft[i];
            i-=( i&(-i) );
        }
        return ans;
    }
    //update value x in index i => lead to update in all other dependent indices
    void update(int i,int x){
        //1 based indexing
        i++;
        while(i<ft.length){
            ft[i]+=x;
            i+=( i&(-i) );
        }
    }
}
