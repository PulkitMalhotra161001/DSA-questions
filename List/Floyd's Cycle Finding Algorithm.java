public static boolean detectLoop(Node head){
    Node fast=head.next;
    Node slow=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(fast==slow && fast.data==slow.data){
            break;
        }
    }
    return fast==slow && fast.data==slow.data;
}

_____________________________________________________________________________________________________________________________________________________________
//Another good approach
//1 ≤ Data on Node ≤ 103

public static boolean detectLoop(Node head){
    
    //null and not marked
    while (head != null && head.data != -1){
        //mark
        head.data = -1;
        head = head.next;
    }
    
    //if head is null means no cycle
    return head!=null;
}
