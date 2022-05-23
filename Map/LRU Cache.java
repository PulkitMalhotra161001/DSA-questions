class LRUCache {
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node head, tail;
    Map<Integer,Node> map=new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        
        this.capacity=capacity;
        //default head and tail
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        //head is left side and tail on right
        head.next=tail;
        tail.prev=head;
        head.prev=null;
        tail.next=null;
        
    }
    
    public int get(int key) {
        Node get=map.get(key);
        
        //value not present
        if(get==null)   return -1;
        
        //latest used
        moveToHead(get);
        
        return get.value;
    }
    
    public void put(int key, int value) {
        
        //value is already present
        Node present=map.get(key);
 
        //not present
        if(present==null){
            
            Node add=new Node(key,value);
            
            //size is already full
            if(map.size()==capacity){
                
                //removed the last recently used
                Node remove=tail.prev;
                remove(remove);
                
                //from map also
                map.remove(remove.key);
            }
            
            //put a new one
            map.put(key,add);
            addToHead(add);
        }

        //node already present in map
        else{
            
            //change the value
            //this is the latest used node 
            present.value=value;
            moveToHead(present);
        }
    }
    
    //move the node to the head
    private void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }
    
    //for removal node
    private void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        next.prev=prev;
        prev.next=next;
    }
    
    //for adding node into head
    private void addToHead(Node node){
        node.prev=head;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
    }
}
