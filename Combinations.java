class Solution {
    List<List<Integer>> ans=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(1,n,k);
        return ans;
    }
    public void solve(int si,int n,int k){
        if(temp.size()==k){
            ans.add(new LinkedList<>(temp));  
            return;
        }
        for(int i=si;i<=n;i++){
            temp.add(i);
            solve(i+1,n,k);
            temp.removeLast();
        }
    }
}
