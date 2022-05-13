class Solution {
    List<Integer> ans=new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null)  return;
        if(ans.size()==depth){
            ans.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
