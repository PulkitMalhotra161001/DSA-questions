class TrieNode 
{
    char content; 
    boolean isEnd; 
    LinkedList<TrieNode> childList; 
    public TrieNode(char c)
    {
        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
    }  
}
class Solution
{
    void deleteKey(TrieNode root,String key){
        if(key.length()==0){
            root.isEnd = false;
            return;
        }
        for(TrieNode child:root.childList){
            if(child.content==key.charAt(0)){
                deleteKey(child,key.substring(1));
            }
        }
    }
    void insert(TrieNode root, String key) {
        if(key.length()==0){
            root.isEndOfWord = true;
            return;
        }
        if(root.children[key.charAt(0)-'a']==null)  root.children[key.charAt(0)-'a']=new TrieNode();
        insert(root.children[key.charAt(0)-'a'],key.substring(1));
    }
    
    boolean search(TrieNode root, String key)
    {
        if(root==null)  return false;
        if(key.length()==0) return root.isEndOfWord;
        return search(root.children[key.charAt(0)-'a'],key.substring(1));
    }
    void print(TrieNode root){
		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i=0;i<size;i++){
				TrieNode pop = q.remove();
				System.out.print(pop.content+(isEnd?"* ":" "));
				for(TrieNode child:pop.children){
					q.add(child);
				}
			}
			System.out.println();
		}
		System.out.println();
    }
}
