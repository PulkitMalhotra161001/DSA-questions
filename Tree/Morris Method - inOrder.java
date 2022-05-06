class Solution {
    // Threaded binary tree and Explaination of Morris Method
    // https://www.youtube.com/watch?v=2BdY9fixMrM
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans=new LinkedList<>();
        TreeNode cur=root;
        
        //while condition is true
        while(cur!=null){
            
            //left exist
            if(cur.left!=null){
                
                //find predecessor
                TreeNode predecessor=find(cur);
                
                //precessor found
                if(predecessor.right==null){
                    
                    //set their right
                    //we will come back here
                    //after printing all it's left nodes
                    predecessor.right=cur;
                    
                    //move to left for traversal
                    cur=cur.left;
                }
                
                //predecesoor is alredy pointing somwhere (cur node)
                else{
                    
                    //set right as null
                    //removing right value
                    //we traversed left subtree
                    predecessor.right=null;
                    
                    //add this node
                    ans.add(cur.val);
                    
                    //right subtree turn
                    cur=cur.right;
                
                }
            }
            
            
            else{
                
                //left subtree is null
                //print this and travel right
                ans.add(cur.val);
                cur=cur.right;
            }
        }
        
        //this is our inorder traversal
        return ans;
    }
    
    
    public TreeNode find(TreeNode root){
        //predecessor condition
        //go to left
        //while(right is true)
        TreeNode cur=root.left;
        while(cur.right!=null && cur.right!=root){
            cur=cur.right;
        }
        //this is the predecessor
        return cur;
    }
    
    
}
