class Solution {
    List<Integer> ans=new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null)  return;
        //if this value is not having anything (assume size=0 && depth=0)
        if(ans.size()==depth){
            ans.add(root.val);
        }
        //traverse right (first) for right view
        //or traverse left (first) for left view
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
