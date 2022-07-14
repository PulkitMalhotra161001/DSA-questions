public static void transformTree (Node root){
    r_inorder(root,0);
}
public static int r_inorder(Node root,int par_val){
    if(root==null)  return 0;
    int right = r_inorder(root.right,par_val);
    int now=root.data;
    //if have right means par_val is already added
    root.data=root.right==null?par_val+right:right;
    int left = r_inorder(root.left,root.data+now);
    return left==0?root.data+now:left;
}
