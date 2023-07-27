// https://practice.geeksforgeeks.org/problems/d857113143f69fab217cf5dab978535542f3cbb1/1


class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Node tree=new Node();
        for(String i:B){
            tree.add(tree,i);
        }
        return tree.search(tree,tree,A)?1:0;
    }
}

class Node{
    Node child[];
    boolean end;
    Node(){
        child=new Node[26];
        for(int i=0;i<26;i++){
            child[i]=null;
        }
        end=false;
    }
    
    
    void add(Node cur,String s){
        
        //string is added
        if(s.length()==0){
            cur.end=true;
            return;
        }
        
        int index=s.charAt(0)-'a';
        
        //not present
        if(cur.child[index]==null){
            cur.child[index]=new Node();
        }
        
        //recursion
        add(cur.child[index],s.substring(1));
        
    }
    
    boolean search(Node cur,Node root,String s){
        
        //searching is completed (value's found)
        //check wheather a word end with this (or maybe we have bigger length string)
        if(s.length()==0)   return cur.end;
        
        int index=s.charAt(0)-'a';
        
        //not present
        if(cur.child[index]==null)
            return false;
        
        //next node location
        Node next=cur.child[index];
        
        //continue with this path || if there's a substring end at i check remaining string from root also
        return search(next,root,s.substring(1)) || (next.end?search(root,root,s.substring(1)):false);
    }
}
