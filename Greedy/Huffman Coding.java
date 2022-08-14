class Solution {
    class Huffman{
        char c;
        int val;
        Huffman left;
        Huffman right;
        public Huffman(char c,int val){
            this.c=c;
            this.val=val;
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Huffman> min_heap=new PriorityQueue<>((o1,o2)->o1.val>=o2.val?1:-1);
        for(int i=0;i<N;i++){
            Huffman hm=new Huffman(S.charAt(i),f[i]);
            min_heap.add(hm);
        }
        Huffman root=null;
        while(min_heap.size()>1){
            Huffman x=min_heap.poll();
            Huffman y=min_heap.poll();
            Huffman temp=new Huffman('-',x.val+y.val);
            temp.left=x;
            temp.right=y;
            root=temp;
            min_heap.add(temp);
        }
        ArrayList<String> ans=new ArrayList<>();
        preorder(root,ans,"");
        return ans;
    }
    public void preorder(Huffman root,ArrayList<String> ans,String till_now){
        if(root==null){ 
            return;
        }
        if(Character.isLetter(root.c))
            ans.add(till_now);
        preorder(root.left,ans,till_now+"0");
        preorder(root.right,ans,till_now+"1");
    }
}
