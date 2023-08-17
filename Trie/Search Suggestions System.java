// https://leetcode.com/problems/search-suggestions-system

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String p:products)  trie.insert(p);
        List<List<String>> ans = new ArrayList<>();
        
        String temp="";
        for(char w:searchWord.toCharArray()){
            temp+=w;
            ans.add( trie.find(temp) );
        }
        
        return ans;
    }
}

class Trie{
    List<String> res;
    Node root,curr;
    
    class Node{
        boolean isWord=false;
        Node child[]=new Node[26];
    }
    
    Trie(){
        root=new Node();
    }
    
    void insert(String s){
        curr=root;
        for(char i:s.toCharArray()){
            if(curr.child[i-'a']==null){
                curr.child[i-'a'] = new Node();
            }
            curr =  curr.child[i-'a'];
        }
        curr.isWord=true;
    }
    
    List<String> find(String s){
        res = new ArrayList<>();
        curr=root;
        for(int i=0;i<s.length();i++){
            if(curr.child[s.charAt(i)-'a']==null)   return res;
            curr =  curr.child[s.charAt(i)-'a'];
        }
        fill_list(curr,s);
        return res;
    }
    
    void fill_list(Node curr,String s){
        if(res.size()==3)   return;
        if(curr.isWord) res.add(s);
        
        for(char i='a';i<='z';i++){
            if(curr.child[i-'a']!=null) fill_list(curr.child[i-'a'],s+i);
        }
    }
    
}
