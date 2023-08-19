// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/
// Spend whole day

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Edge> adj=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> critical  = new HashSet<>();
        List<Integer> pseudo  = new ArrayList<>();
        int m=edges.length;
        for(int i=0;i<m;i++)  adj.add(new Edge(edges[i][0],edges[i][1],edges[i][2],i));
        //sorted by wgt
        Collections.sort(adj);
        
        //skip none edge
        int mst_value = MST_Value(adj,n,-1,null);
        
        //if removing current edge will increases mst_value means this edge is critical
        for(int i=0;i<m;i++){
            int temp = MST_Value(adj,n,i,null);
            // System.out.println(temp);
            if(temp>mst_value)  critical.add(i);
        }
        
        //we have to compulsory take current edge and if our ans is same means edge is participating in any one of the MST (hence pseudo-critical)
        for(int i=0;i<m;i++){
            Edge complusion = new Edge(edges[i][0],edges[i][1],edges[i][2],i);
            int temp = MST_Value(adj,n,-1,complusion);
            
            if(temp==mst_value){
                //critical edges will also included here but we don't want
                if(critical.contains(i))    continue;
                else    pseudo.add(i);
            }
            // System.out.println(temp);
        }
        
        
        ans.add(new ArrayList<>(critical));
        ans.add(pseudo);
        return ans;
    }
    int MST_Value(List<Edge> adj,int n,int skip_node_no,Edge comp){
        UnionFind uf = new UnionFind(n);
        int ans=0;
        if(comp!=null){
            uf.union(comp.start,comp.end);
            ans+=comp.wgt;
        }
        
        for(Edge i:adj){
            if(i.index==skip_node_no)   continue;
            boolean uf_res = uf.union(i.start,i.end);
            if(uf_res)  ans+=i.wgt;
        }

        //removing edge can lead to graph disconnection
        //to check if graph is connected there is only one parent node for all nodes
        int par_nodes=0;
        for(int i=0;i<n;i++){
            if(uf.par[i]==i)    par_nodes++;
        }
        
        //means graph are in multiple pieces
        if(par_nodes>1)   return Integer.MAX_VALUE;
        
        return ans;
    }
}
class Edge implements Comparable<Edge>{
    int start;
    int end;
    int wgt;
    int index;
    Edge(int s,int e,int w,int i){
        start=s;
        end=e;
        wgt=w;
        index=i;
    }
    public int compareTo(Edge node){
        return wgt-node.wgt;
    }
}
class UnionFind{
    int par[];
    int n;
    int rank[];
    UnionFind(int n){
        this.n=n;
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++)    par[i]=i;
    }
    int find(int x){
        if(par[x]==x)   return x;
        //path compression
        return par[x] = find(par[x]);
    }
    boolean union(int x,int y){
        int a = find(x);
        int b = find(y);
        //already same group no union
        if(a==b)    return false;
        
        //union by rank
        if(rank[a]>rank[b]){
            par[b]=a;
        }else if(rank[a]<rank[b]){
            par[a]=b;
        }else{
            par[a]=b;
            rank[b]++;
        }
        //successfully joined
        return true;
    }
    
}
