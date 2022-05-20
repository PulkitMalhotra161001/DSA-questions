/*          Find shortest path from source to all it's vertices

Similar to dijkstra

Bellman Ford algorithm will work in
Directed Graph and UnDirected Graph if there is a +ve edge
for -ve edge if there is a +ve cycle.
but for -ve cycle this algo not work. But it will detect you a -ve cycle.

https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#

After relaxing the n-1 times we have the smallest distance and we can't have any further shortest distance
why n-1

eg. 0 -> 1 -> 2 -> 3 -> 4
edges {3->4, 1} , {2->3, 1} , {1->2 , 1} , {0->1 , 1}
first relaxation 0->1 will get updated
second relaxation 1->2 will get updated
third relaxation 2->3 will get updated
fourth relaxation 3->4 will get updated
all get's updated after n-1 relaxation
this is the worst ordering of edges*/

public int isNegativeWeightCycle(int n, int[][] edges){
    int dist[]=new int[n];
    Arrays.fill(dist,100000000);
    dist[0]=0;
    for(int i=0;i<n-1;i++){
        // Relax it for n-1 times
        // will result into smallest distance
        for(int j[]:edges){
            // u + wgt < v
            if(dist[j[0]]+j[2]<dist[j[1]]){
                // v = u + wgt
                dist[j[1]] = dist[j[0]] + j[2];
            }
        }
    }
    
    //At this point dist array store the shortest path from source to all it's vertices

    // After relaxing one more time if distance reduces it means it have an -ve cycle
    
    for(int j[]:edges){
        if(dist[j[0]]+j[2]<dist[j[1]]){
            // it has -ve cycle
            return 1;
        }
    }

    return 0;

}

// https://www.youtube.com/watch?v=75yC1vbS8S8&t=1388s
// TC = O( V * E )
