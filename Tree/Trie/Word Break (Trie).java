// https://practice.geeksforgeeks.org/problems/d857113143f69fab217cf5dab978535542f3cbb1/1


class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        Node tree=new Node();
        for(String i:B){
            // System.out.println(i);
            tree.add(tree,i);
        }
        return tree.solve(tree,A)?1:0;
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
        if(s.length()==0){
            // System.out.println("Hi");
            return cur.end;
        }
        int index=s.charAt(0)-'a';
        
        if(cur.child[index]==null)
            return false;
        
        Node next=cur.child[index];
        return search(next,root,s.substring(1));
    }
    boolean solve(Node root, String s){
        int n=s.length();
        if(n==0)return true;
        
        // Try all prefixes of lengths from 1 to size
        for(int i=1;i<=n;i++){
            
            // prefix (of input string) of
            // length 'i'. We first check whether
            // current prefix is in dictionary.
            // Then we recursively check for remaining
            if ( search(root,root, s.substring(0, i)) && solve(root,s.substring(i)) )
                return true;
        }
        return false;
    }
}
