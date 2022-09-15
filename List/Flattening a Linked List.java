// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

Node flatten(Node root)
    {
        Node ans=root;
        root=root.next;
        while(root!=null){
            Node ptr=ans;
            Node btm=root;
            // System.out.println();
            while(btm!=null){
                
                if(ptr.data>btm.data){
                    Node new_head=new Node(btm.data);
                    new_head.bottom=ans;
                    ans=new_head;
                }else{
                    //bottom traversal
                    while(ptr.bottom!=null && ptr.bottom.data<btm.data){
                        ptr=ptr.bottom;
                    }
                    
                    Node rem=ptr.bottom;
                    ptr.bottom=new Node(btm.data);
                    ptr=ptr.bottom;
                    ptr.bottom=rem;
                }
                
                btm=btm.bottom;
                
            }
            root=root.next;
        }
        
        return ans;
    }

___________________________________________________________________________________________________________________________________________________________

Node flatten(Node root)
    {
        if(root==null || root.next==null)   return root;
        
        root.next=flatten(root.next);
        
        root=merge_sort(root,root.next);
        
        return root;
    }
    Node merge_sort(Node a,Node b){
        if(a==null) return b;
        if(b==null) return a;
        
        Node res;
        
        if(a.data<b.data){
            res=a;
            res.bottom=merge_sort(a.bottom,b);
        }else{
            res=b;
            res.bottom=merge_sort(a,b.bottom);
        }
        
        return res;
    }
