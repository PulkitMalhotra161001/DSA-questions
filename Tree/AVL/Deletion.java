class Sol{
    // https://practice.geeksforgeeks.org/problems/avl-tree-deletion/1
    
    // Find the maximum value in a subtree rooted at the given node
    static int findMax(Node head) {
        if (head == null)   return -1; // Return -1 for an empty subtree
        while (head.left != null) {
            head = head.left; // Traverse to the leftmost node
        }
        return head.data; // Return the data of the leftmost node (maximum value)
    }

    // Delete a node with the given data from the tree
    public static Node deleteNode(Node root, int data) {
        root = call(root,data);
        // print(root);
        return root;
    }
    static Node call(Node root, int data) {
        if (root == null)   return root; 

        if (root.data < data)
            root.right = call(root.right, data);
        else if (root.data > data)
            root.left = call(root.left, data);
        else {
            // Node to be deleted found
            if (root.left == null || root.right == null) {
                // Node has one child or no child
                Node temp = (root.left == null) ? root.right : root.left;
                root = temp;
            } else {
                // Node has two children
                int successor = findMax(root.right);
                root.data = successor;
                root.right = call(root.right, successor); // Delete the successor node
            }
        }

        // Calculate the balance factor of the root node
        int bf=balance_factor(root);
        if(bf==2){
            if(balance_factor(root.left)==-1){
                root.left=left_rotation(root.left);
            }
            root=right_rotation(root);
            
        }
        else if(bf==-2){
            if(balance_factor(root.right)==1){
                root.right=right_rotation(root.right);
            }
            root=left_rotation(root);
        }
        //remove removed (stackTrace => redefine height)
        if(root!=null)  root.height=1+Math.max(height(root.left),height(root.right));
        return root;
    }
    
    
    static int height(Node node){
        if(node==null)  return 0;
        return node.height;
    }
    static int balance_factor(Node node){
        if(node==null)  return 0;
        return height(node.left)-height(node.right);
    }
 
    static void print(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb_main=new StringBuilder();
        while(!q.isEmpty()){
            int size=q.size();
            boolean has_value = false;
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<size;i++){
                Node pop = q.remove();
                if(pop==null){
                    sb.append("N ");
                    continue;
                }   
                else{
                    has_value = true;
                    sb.append(pop.data+" ");
                }
                q.add(pop.left);
                q.add(pop.right);
            }
            if(has_value)   sb_main.append(sb+"/ ");
        }
        System.out.println(sb_main);
    }
 
    static Node right_rotation(Node root) {
        Node new_head=root.left;
        Node img=new_head.right;
        new_head.right=root;
        root.left=img;
        root.height=1+Math.max(height(root.left),height(root.right));
        new_head.height=1+Math.max(height(new_head.left),height(new_head.right));
        return new_head;
    }
 
    static Node left_rotation(Node root) {
        Node new_head=root.right;
        Node img=new_head.left;
        new_head.left=root;
        root.right=img;
        root.height=1+Math.max(height(root.left),height(root.right));
        new_head.height=1+Math.max(height(new_head.left),height(new_head.right));
        return new_head;
    }
 
}
