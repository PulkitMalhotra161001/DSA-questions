// Graph
// Negative weight cycle
// GFG

public int isNegativeWeightCycle(int n, int[][] edges){
    int dist[]=new int[n];
    Arrays.fill(dist,100000000);
    dist[0]=0;
    for(int i=0;i<n;i++){
        for(int j[]:edges){
            if(dist[j[0]]+j[2]<dist[j[1]]){
                dist[j[1]] = dist[j[0]] + j[2];
            }
        }
    }

    for(int j[]:edges){
        if(dist[j[0]]+j[2]<dist[j[1]]){
            return 1;
        }
    }

    return 0;

}

// https://www.youtube.com/watch?v=75yC1vbS8S8&t=1388s
