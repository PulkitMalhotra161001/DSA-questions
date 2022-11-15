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


_______________________________________________________________________________________________________________________________________________________________
//approach 2 : LinkedHashMap

class LRUCache {
    Map<Integer,Integer> map;
    int n;
    public LRUCache(int capacity) {
        map=new LinkedHashMap<>();
        n=capacity;
    }
    
    public int get(int key) {
        int ans = map.getOrDefault(key,-1);
        //if it contains
        if(ans>-1){
            //we removed the element
            map.remove(key);
            //and pushed back
            map.put(key,ans);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        
        //if it reached size and doesn't contain key and remove least used key
        if(map.size()>=n && !map.containsKey(key))    map.remove( map.keySet().iterator().next() );
        
        //if map contain key then just remove it and pushed back
        if(map.containsKey(key))   map.remove(key);
        
        //if not contain then added
        map.put(key,value);
    }
}


_______________________________________________________________________________________________________________________________________________________________
//way 2

class LRUCache extends LinkedHashMap<Integer,Integer>{
    
    int n;
    
    public LRUCache(int capacity) {
        
        //size => capacity
        //load factor => 0.75f
        //accessOrder  => true means ordering mode
		//                false means insertion mode
        super(capacity,0.75f,true);
        n=capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }
    
/*      removeEldestEntry is useful if the map represents a cache: it allows
	    the map to reduce memory consumption by deleting stale entries.	It 
		work if the accessOrder is true

		eldest The least recently inserted entry in the map, or if
	    this is an access-ordered map, the least recently accessed
	    entry.
*/
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return super.size()>n;
    }
}
