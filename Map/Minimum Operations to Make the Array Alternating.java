//priorityqueue comparitor
class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer,Integer> even=new HashMap<>();
        Map<Integer,Integer> odd=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if((i&1)==0){
                even.merge(nums[i],1,Integer::sum);
            }
            else{
                odd.merge(nums[i],1,Integer::sum);
            }
        }
        
        Queue<Node> even_q=new PriorityQueue<>((x,y)->y.freq-x.freq);
        Queue<Node> odd_q=new PriorityQueue<>((x,y)->y.freq-x.freq);
        
        for(Map.Entry<Integer,Integer> i:even.entrySet()){
            even_q.add(new Node(i.getKey(),i.getValue()));
        }
        
        for(Map.Entry<Integer,Integer> i:odd.entrySet()){
            odd_q.add(new Node(i.getKey(),i.getValue()));
        }
        
        while(!even_q.isEmpty() && !odd_q.isEmpty() && even_q.peek().value==odd_q.peek().value){
            if(odd_q.peek().freq<even_q.peek().freq){
                odd_q.remove();
            }
            else{
                even_q.remove();
            }
        }
        
        if((n&1)==0){
            return (even_q.isEmpty()?n/2:n/2-even_q.peek().freq)+(odd_q.isEmpty()?n/2:n/2-odd_q.peek().freq);
        }
        return (even_q.isEmpty()?n/2:n/2-even_q.peek().freq)+(odd_q.isEmpty()?(n/2+1):(n/2+1)-odd_q.peek().freq);
        
    }
    
    class Node{
        int value;
        int freq;
        public Node(int v,int f){
            value=v;
            freq=f;
        }
    }
}
