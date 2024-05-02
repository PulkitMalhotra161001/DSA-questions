// https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1#

// Hamiltonian Path - start from a vertex and visit all vertices without visiting the vertex more than one time.

// Hamiltonian Cycle - start from a vertex, visit all vertices, visit only one time, there must be a direct edge between last vertex and starting vertex.

class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        // System.out.println(Edges);
        for(ArrayList<Integer> i:Edges){
            //undirected graph
            list.get(i.get(0)).add(i.get(1));
            list.get(i.get(1)).add(i.get(0));
        }
        
        // System.out.println(list);
        //traverse for all vertecies
        //makes start from every vertex 
        for(int i=1;i<=N;i++){
            //set for visited
            Set<Integer> vis=new HashSet<>();
            if(!vis.contains(i)){
                //do dfs is not visited
                if(dfs(i,N,list,vis)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    boolean dfs(int src,int total,List<List<Integer>> list,Set<Integer> vis){
        
        //mark visit this vertex
        vis.add(src);
        
        /*if we have traversed all vertices
        size if equal to list size
        -1 is bcz in this case we have 1 based inding list*/
        if(vis.size()==list.size()-1){
            
            //this is the Hamiltonian Path
            return true;
            
            /*add two parameters in function 
            1. original source (for Hamiltonian cycle) (which we don't change)
                if we have to print paths then path so far is essentail
                if we have to just print how many paths and cycles present then we don't need
            2. path so far (string) (which maintain the path that we traversed)
                so at end we can differentiate between path and cycle
            for Hamiltonian cycle we just need to traverse 
            list.source and if there is a direct edge between this source(end of graph) to the original source
            then this it is called Hamiltonian cycle*/
        }   
    
        // System.out.println(src+"->"+total);
        for(Integer nbr:list.get(src)){
            
            //simple dfs
            //if not visited then traverse
            if(!vis.contains(nbr)){
                
                //in this question
                //we have to check if there is a path
                if(dfs(nbr,total-1,list,vis)) return true;
            }
        }
        
        //there can be any other possibility also
        vis.remove(src);
        return false;
    }
} 
