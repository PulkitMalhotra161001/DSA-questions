class Solution
{
    //for storing current node and dist (horizontal)
    class Details{
        Node root;
        int dist;
        public Details(Node r,int d){
            root=r;
            dist=d;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // for level order traversal
        Queue<Details> q=new LinkedList<>();
        // for storing the root.val at horizontal distance
        Map<Integer,Integer> map=new TreeMap<>();
        if(root!=null)
            q.add(new Details(root,0));
            
        while(!q.isEmpty()){
            Details pop=q.remove();
            
            Node node=pop.root;
            int dist=pop.dist;
            // we put every element irrespective or the case
            // put the parent ele
            // if child have some value then they will change as this is bottom view
            map.put(dist,node.data);
            
            if(node.left!=null){
                // for left horizonal distance is decreases
                q.add(new Details(node.left,dist-1));
            }
            if(node.right!=null){
                // for right horizonal distance is increases
                q.add(new Details(node.right,dist+1));
            }
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(Integer k:map.keySet()){
            al.add(map.get(k));
        }
        return al;
    }
}


// Top View
line 30 ->

if(!map.containsKey(dist))
    map.put(dist,node.data);

// as we are going down (level order)
// in top view element must be in top of all the elements
// conclude: if horizontal distance position is already visited then containing value is top view value
