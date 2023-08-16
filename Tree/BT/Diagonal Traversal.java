class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
        
        fill(map,root,0);
        
        ArrayList<Integer> ans = new ArrayList<>();

        for(Integer key:map.keySet()){
            ans.addAll(map.get(key));
        }
        
        return ans;
        
    }
    public void fill(TreeMap<Integer,ArrayList<Integer>> map,Node root,int level){
        if(root==null)  return;
        ArrayList<Integer> temp = new ArrayList<>();
        if(map.containsKey(level)){
            temp=map.get(level);
        }
        temp.add(root.data);
        map.put(level,temp);
        fill(map,root.left,level+1);
        fill(map,root.right,level);
    }
}

______________________________________________________________________________________________________________________________________________________________
//approach 2

public ArrayList<Integer> diagonal(Node root)
    {
        
        Queue<Node> q=new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node temp=q.remove();
            
            while(temp!=null){
                ans.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                
                temp=temp.right;
            }
            
        }

        return ans;
        
    }
