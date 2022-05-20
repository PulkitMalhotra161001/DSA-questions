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
