//we have to find minimum shortest tree like prim's algo
//in this approach we use union find to calculate our result

//we have a class bcz the input graph is not very much helpful
//sorted the graph according to the weight (shortest weight first)
class Edge implements Comparable<Edge>{
    int source, dest, wgt;
    Edge(int s,int d,int w){
        source=s;
        dest=d;
        wgt=w;
    }
    public int compareTo(Edge node){
        return wgt-node.wgt;
    }
}

class Solution
{
    //parent array to "find" the parent of any index
    static int parent[];
    //rank array for minimizing the height
    static int rank[];

    // Find representative of a set
    static int find(int x){
        // (path compression)
        //if this value is not representative of his own value then find the representative of a set
        //directly set the representative value into x
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    
    static void union(int X,int Y){
        //find representative of X
        int x=find(X);
        //find representative of X
        int y=find(Y);
        
        //if both representative are same (both lies in same set)
        if(x==y){
            return;
        }
        
        //whose ever rank is low (small height)
        //inserted into the large height value
        if(rank[x]<rank[y]){
            //y becomes parent of x
            parent[x]=y;
        }else if(rank[y]<rank[x]){
            //x becomes parent of y
            parent[y]=x;
        }else{
            //both have same height
            //y becomes parent of x (doesn't matter)
            parent[x]=y;
            //y is top on x (means x is inserted into height)
            //imagine it like a tree (one more branch attached to head with same height)
            rank[y]++;
        }
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        ArrayList<Edge> list=new ArrayList<>();
        
        parent=new int[V];
        //every one has rank(height) 0
        rank=new int[V];
        for(int i=0;i<V;i++){
            //i become parent of itself
            parent[i]=i;
        }
        
        //just for 0->1:5 , 1->0:5
        //for tackling double edges which is present into adj
        boolean vis[][]=new boolean[V][V];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                ArrayList<Integer> temp=adj.get(i).get(j);
                
                //value is not visited (source->desination)
                if( !vis[i][temp.get(0)] ){
                    vis[i][temp.get(0)]=true;
                    vis[temp.get(0)][i]=true;
                    //add into our list
                    list.add(new Edge( i, temp.get(0), temp.get(1) ));
                }
            }
        }
        
        
        //sort for getting the smallest weight
        Collections.sort(list);
        // for(Edge i:list){
        //     System.out.println(i.source+"->"+i.dest+" : "+i.wgt);
        // }
        
        //for one node the ans is 0
        int ans=0;
        int curr_node=1;
        
        //traverse in list
        //we need only V-1 edges to coonect all vertices
        for(int i=0;curr_node<V;i++){
            
            //getting the list componenet
            Edge temp=list.get(i);
            
            //source and destination representative
            int x=find(temp.source);
            int y=find(temp.dest);
            
            //if they both lies into different sets
            //they both not visited before (no edge between them till now)
            if(x!=y){
                // System.out.println("Union : "+x+" "+y);
                //
                
                //make and edge between them
                union(x,y);
                
                //one edge is inserted
                curr_node++;
                
                //add this source node to destination node weight to the ans
                ans+=temp.wgt;
            }
        }
        
        //minimum spanning tree ans
        //minimum wire need to connect all vertices
        return ans;
        
    }
}
