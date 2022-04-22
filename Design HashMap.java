//we have 3 functions - put, get, remove

class MyHashMap<K,V> {
    
    //class for storing key and value pair of generic type
    class ListNode{
        K key;
        V value;
        ListNode(K key, V value){
            this.key=key;
            this.value=value;
        }
    }
    
    //our list of listnode type
    LinkedList<ListNode> arr[];
    int size;
    public MyHashMap() {
        
        //default list size is 16
        init_size(16);
        size=0;
    }
    
    public void init_size(int size){
        
        //for every index we have list
        //bcz when we find the hashcode of any key we have to add it into index(hashcode)
        arr=new LinkedList[size];
        for(int i=0;i<size;i++){
            arr[i]=new LinkedList<>();
        }
        
    }
    
    public void put(K key, V value) {
        
        //get the list index
        //a list where values are present whose hashcode is same\
        //list can be large for that we do the rehashing
        int li=get_list_index(key);
        
        //we find the index of value
        //if value is present then it return index
        //else (value is not present) -1
        int id=get_index_in_list(key,li);
        
        if(id==-1){
            //value not present - we need to insert
            ListNode node=new ListNode(key,value);
            //added value in the index of list[index]
            arr[li].add(node);
            size++;
        }else{
            //already present - we just need to change
            arr[li].get(id).value=value;
        }
        
        
        //this is the loading factor
        //time taken to find values int list of list
        double lambda=size*1.0/arr.length;
        if(lambda>0.75){
            //time taken is more than standard time
            rehash();
        }
        
    }
    
    public void rehash(){
        
        LinkedList<ListNode> old[]=arr;
        
        //increase size of list(arr)
        init_size(arr.length*2);
        
        //traverse and put value
        for(int i=0;i<old.length;i++){
            for(ListNode ln:old[i]){
                //this is the listnode
                //we have to put in the arr
                int li=get_list_index(ln.key);
                //get the hashcode and put value
                arr[li].add(ln);
            }
        }
    }
    
    
    public int get_index_in_list(K key, int li){
        
        //used to find whether key is present in the list or not
        for(int j=0;j<arr[li].size();j++){
            ListNode cur=arr[li].get(j);
            if(cur.key.equals(key)){
                //value present
                return j;
            }
        }
        //value not present
        return -1;
    }
    
    //this is the hash func
    public int get_list_index(K key){
        //most work is done by the inbuild system of hashcode
        //we just compress it into our range
        return Math.abs( key.hashCode() ) % arr.length ;
    }
    
    public int get(K key) {
        //get the list index or hashcode(compressed by the size)
        int li=get_list_index(key);
        //get the key
        int id=get_index_in_list(key,li);
        if(id==-1){
            //key is -1 = value not present
            return -1;
        }
        //value present = return value
        //return type is int for that we have to type cast
        return (int)arr[li].get(id).value;
    }
    
    public void remove(K key) {
        //get list index or hash code
        int li=get_list_index(key);
        //get position
        int id=get_index_in_list(key,li);
        //value is present
        if(id!=-1){
            //just remove in the list
            arr[li].remove(id);
            //and size get decremented
            size--;
        }
    }
}
