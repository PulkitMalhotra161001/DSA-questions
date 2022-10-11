// https://practice.geeksforgeeks.org/problems/number-of-islands/1

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> ans=new ArrayList<>();
        uf a=new uf(rows*cols);
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
        
        for(int op[]:operators){
            int i=op[0];
            int j=op[1];
            int index=i*cols+j;
            a.addland(index);
            
            
            for(int d[]:dir){
                int ni=i+d[0];
                int nj=j+d[1];
                int n_index=ni*cols+nj;
                if(safe(ni,nj,rows,cols) && a.island(n_index)){
                    //neighbour contains a land also, so we need to merge
                    a.union(index,n_index);
                }
            }
            
            ans.add(a.count);
        }
        
        return ans;
    }
    
    boolean safe(int i,int j,int n,int m){
        return i>=0 && j>=0 &&  i<n && j<m ;
    }
    
}

class uf{
    int parent[], rank[], count;
    uf(int n){
        parent=new int[n];
        rank=new int[n];
    }
    public void addland(int x){
        //already a land
        if(island(x))   return;
        else{
            parent[x]=x;
            rank[x]=1;
            count++;
        }
    }
    public boolean island(int x){
        return rank[x]!=0;
    }
    int find(int x){
        if(parent[x]==x)    return x;
        //path compression
        return parent[x]=find(parent[x]);
    }
    public void union(int a,int b){
        int ap=find(a);
        int bp=find(b);
        if(ap==bp)  return;

        //union by rank
        else{
            if(rank[ap]<rank[bp]){
                parent[ap]=bp;
            }else if(rank[bp]<rank[ap]){
                parent[bp]=ap;
            }else{
                parent[bp]=ap;
                rank[ap]++;
            }
            count--;
        }
    }
}
