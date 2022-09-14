// https://leetcode.com/problems/reverse-nodes-in-k-group/

public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode a=head, b=head;
        
        //loop for reversel
        for(int i=0;i<k;i++){
            //ilst don't contains k elements
            if(b==null) return head;
            b=b.next;
        }
        
        //reversed the first k elemets
        ListNode ans=reverse_till_k(a,b);
        
        //recursive call for the remaining elemets
        a.next=reverseKGroup(b,k);
        
        //return the new_head node
        return ans;
    }
    
    ListNode reverse_till_k(ListNode a,ListNode b){
        
        ListNode prev=null, next=null;
        while(a!=b){
            next=a.next;
            a.next=prev;
            prev=a;
            a=next;
        }
        return prev;
    }
