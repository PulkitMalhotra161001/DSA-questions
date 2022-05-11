// Bellman Ford algorithm will work in
// Directed Graph if there is a +ve edge or if there is a -ve edge
// UnDirected Graph it has to convert it into directed graph using bidirectional edges 
// It will not work if there is a -ve cycle. But it will detect you a -ve cycle.

// Negative weight cycle
// GFG

// After relaxing the n-1 times we have the smallest distance and we can't have any further shortest distance
// why n-1

// eg. 0 -> 1 -> 2 -> 3 -> 4
// edges {3->4, 1} , {2->3, 1} , {1->2 , 1} , {0->1 , 1}
// first relaxation 0->1 will get updated
// second relaxation 1->2 will get updated
// third relaxation 2->3 will get updated
// fourth relaxation 3->4 will get updated
// all get's updated after n-1 relaxation
// this is the worst ordering of edges

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
// TC = o( (n-1) * (E) )
