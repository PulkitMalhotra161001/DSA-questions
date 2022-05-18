/* https://www.youtube.com/watch?v=VrqBX-Tck2A

eulerian graph it have 2 things
eulerian path and eulerian circuit
(eulerian circuit is having eulerian path as well)

eulerian path
From one node we have to go to other node (via an edge), once an edge is traversed we can't move via same edge
so we come to a node now we have to move to other node; there must be atleast two edge present while traversing
or there will be odd edge at starting and odd edge at end
bcz if there is a straight line(graph); there is 1(odd) edge at starting node, there is 2(even) edges in middle nodes, there is 1(odd) edge at ending node
this is also a valid eulerian path
conclude: there must be n even edges or there must be 2 odd edges

eulerian circuit
from which node we start traversing we must come to that node
there must be 1 proper cycle
conclude: there must be n even edges

eulerian circuit also have eulerian path
*/
public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
{
    int even=0, odd=0;
    
    //chech for odd and even edegs
    for(int i=0;i<adj.size();i++){
        
        int count=adj.get(i).size();
        
        //there is this many edges from this node
        if(count%2==0){
            
            //there is even edges present
            even++;
        }else{
            
            //there is odd edges present
            odd++;
        }
    }

    //there is even edges from n nodes
    //it have eulerian circuit
    //means it also have eulerian path as well
    if(even==V){
        return 2;
    }

    //there is only 2 odd edges(1 for start,1 for end) in n nodes
    //all other are even edges
    //it have eulerian path
    if(odd==2){
        return 1;
    }

    //it doesn't even have eulerian path
    return 0;

}
