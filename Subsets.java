//78 - LeetCode
//subsets of a given array

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solution(nums,0,new ArrayList<>());
        System.out.print(ans);
        return ans;
    }
    public void solution(int a[],int i,List<Integer> l){
        if(i==a.length){
            ans.add(new ArrayList<>(l));
            return;
        }
        solution(a,i+1,l);
        l.add(a[i]);
        solution(a,i+1,l);
        l.remove(l.size()-1);
    }
}

// O( n * 2^n )
