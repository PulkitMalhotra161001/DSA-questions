// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return fill(preorder,0,preorder.length-1);
    }
    TreeNode fill(int a[],int start,int end){
        if(start>end) return null;

        int i=start;
        for(;i<=end;i++){
            //right node
            if(a[i]>a[start])   break;
        }
        
        TreeNode ans=new TreeNode(a[start]);
        ans.left = start+1==i?null : fill(a,start+1,i-1);
        ans.right = i>end?null : fill(a,i,end);
        
        return ans;
    }
}
