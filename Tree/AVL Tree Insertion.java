public  Node insertToAVL(Node node,int data)
    {
        if(node==null){
            return new Node(data);
        }else if(node.data<data){
            node.right=insertToAVL(node.right,data);
        }else if(node.data>data){
            node.left=insertToAVL(node.left,data);
        }else{
            return node;
        }
        node.height=1+Math.max(height(node.left),height(node.right));
                              
        int bf=balance_factor(node);
        if(bf>1){
            // int lbf=balance_factor(node.left);
            // if(lbf<0){
            if(data > node.left.data){
                node.left=left_rotation(node.left);
            }
            node=right_rotation(node);
            
        }
        else if(bf<-1){
            // int rbf=balance_factor(node.right);
            // if(rbf>0){
            if(data < node.right.data){
                node.right=right_rotation(node.right);
            }
            node=left_rotation(node);
        }
 
        return node;
    }
    
    int height(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }
 
 
    Node right_rotation(Node root) {
        Node new_head=root.left;
        Node img=new_head.right;
        new_head.right=root;
        root.left=img;
        root.height=1+Math.max(height(root.left),height(root.right));
        new_head.height=1+Math.max(height(new_head.left),height(new_head.right));
        return new_head;
    }
 
    Node left_rotation(Node root) {
        Node new_head=root.right;
        Node img=new_head.left;
        new_head.left=root;
        root.right=img;
        root.height=1+Math.max(height(root.left),height(root.right));
        new_head.height=1+Math.max(height(new_head.left),height(new_head.right));
        return new_head;
    }
 
     int balance_factor(Node node){
        if(node==null)  return 0;
        return height(node.left)-height(node.right);
    }
