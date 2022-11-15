// leetcode.com/problems/lfu-cache/
// youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79
// github.com/striver79/SDESheet/blob/main/LFUCacheJava

class LFUCache {
    
    // frequency: frequency count of current node
    // (all nodes connected in same double linked list has same frequency)
    class Node{
        int key, value, freq;
        Node next, prev;
        Node(int k,int v,int f){
            key=k;
            value=v;
            freq=f;
        }
        
    }
    
    // double linked list
    // this level contains list who have same frequncies
    class DLL{
        //head and tail node for accessing and traversing the list
        Node head, tail;
        int size;
        DLL(){
            head=new Node(-1,-1,0);
            tail=new Node(-1,-1,0);
            head.next = tail;
            tail.prev = head;
            size=0;
        }
        
        //removing the last node (least used)
        void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }
        
        //adding to front (recently used)
        void addToHead(Node node){
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            size++;
        }
    }
    
    //this hashmap will keep track of nodes who have same frequency
    // {1=>[],[],[]}    {2=>[],[]}      {3,[]}      {4=>[][][][][]}
    Map<Integer,DLL> fmap;
    
    //this will help us to track the keys
    Map<Integer,Node> map;

    //min_freq will help us to track which level of node we have to remove
    int min_freq, cap;
    
    //initializing values
    public LFUCache(int capacity) {
        fmap = new HashMap<>();
        map = new HashMap<>();
        min_freq = 1;
        cap = capacity;
    }
    
    
    public int get(int key) {
        
        Node present = map.get(key);
        
        // if key doesn't exist in map
        if(present==null)   return -1;
        
        //if present then update this node to next freq level
        update(present);
        // System.out.println("Get: "+key+" mf "+min_freq);
        // print();

        // as key exist in map so return it's corresponding value
        return present.value;
        
    }
    
/**
    add new node into LFU cache, as well as double linked list
    condition 1: if LFU cache has input key, update node value and node position in list/freq_map
    condition 2: if LFU cache does NOT have input key
        - sub-condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node, then add new node
        - sub condition 2: if LFU cache has enough space, add new node directly
      
**/

    public void put(int key, int value) {
        if(cap==0)  return;
        
        
        Node present = map.get(key);
        
        //key not present in map
        if(present==null){
            
            //we have to check if map size reached it's capacity
            if(map.size()>=cap){
                //we have to remove least frequent key
                
                //least frequent level
                DLL list = fmap.get(min_freq);
                
                //remove the last node
                Node remove = list.tail.prev;
                list.remove( remove );
                
                //also remove from map (LRU key) 
                map.remove(remove.key);
            }
            
            //key not present in map so we have to add it to 1 freq level
            min_freq = 1;
            Node add = new Node(key,value,1);
            
            //getting the level
            DLL level = fmap.getOrDefault(1,new DLL());

            //adding node
            level.addToHead(add);
            
            //updating frequency map
            fmap.put(1,level);
            
            //also add it to map
            map.put(key,add);
        }
        
        //key already present in map => just change it's value & increment it's level
        else{
            present.value = value;
            update(present);
        }

        // System.out.println("put: "+key+" "+value+" mf "+min_freq);
        // print();
    }
    
    
    //we have to update the level of a node
    //means remove it from current freq level and add it to next level
    void update(Node node){
        
        //node removed from it's frequency level
        fmap.get(node.freq).remove(node);
        
        //if minimum freq level doesn't have any node means next removal is from next level
        if(fmap.get(min_freq).size==0)   min_freq++;
        
        int new_freq = node.freq + 1;
        
        //getting the level
        DLL next_level = fmap.getOrDefault(new_freq,new DLL());
        
        //adding the node
        next_level.addToHead(node);
        
        //updating the level
        fmap.put(new_freq,next_level);
        
        //now this node lie in next stage means it's freq updated
        node.freq++;
    }
    
    
    void print(){

        //getting the level
        for(Integer k:fmap.keySet()){
            
            System.out.println("freq_map: "+k+" size: "+fmap.get(k).size);
            
            //getting the list (this level have)
            Node list = fmap.get(k).head.next;
            
            //printing the nodes in the list
            while(list.next!=null){
                System.out.println(list.key+" "+list.value+" "+list.freq);
                list=list.next;
            }
        }
        System.out.println();
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
