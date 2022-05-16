// 0 1 2 3 4 5 6 (index)
// 0 1 2 3 4 5 6 (value)
// union(2,3)
// 0 1 3 3 4 5 6 (value)
// union(1,6)
// 0 6 3 3 4 5 6 (value)
// union(6,2)
// 0 6 3 3 4 5 2 (value)
// find(1)
// 3

class GfG{
    	//default parent of i is i itself
    
    	// Finds the representative of the set  
    	// that i is an element of
	int find(int parent[],int X){
	    
		// If i is the parent of itself
		// Then i is the representative of 
		// this set
		if(parent[X]==X)    return X;
	    
		// Else if i is not the parent of 
		// itself, then i is not the 
		// representative of his set. So we 
		// recursively call Find on its parent
		return find(parent,parent[X]);
	}
	
	void unionSet(int parent[],int X,int Z){
	    
	    //find parent/representative of the set
	    int x=find(parent,X);
	    int z=find(parent,Z);
	    
	    //z become parent of x
	    parent[x]=z;
	}
	
}

__________________________________________________________________________________________________________________________________________________________
// Improvement 1 :	Union by Rank

//as we have to find the parent x every time
//while performing union we just make z as parent of x
//this may consume time (in future) so we have to make parent whose rank is largest (among them)
//in other words whose rank is smallest become the child (if this become parent then overall time complexity will increase)
// minimize the height of the resulting tree.


//find parent/representative of the set
int x=find(parent,X);
int z=find(parent,Z);

//initially all rank value's is 0
//if rank of x is smaller
//means z is bigger
if(rank[x]<rank[z]){
	//z become parent of x
	parent[x]=z;
}else if(rank[z]<rank[x]){
	//x become parent of z
	parent[z]=x;
}else{
	//both have same length
	// z become parent of x
	//(doesn't matter which one goes where)
	parent[x]=z;
	//z become parent, now it's length is increases by 1 (one new value/child added)
	rank[z]+=1;
}

___________________________________________________________________________________________________________________________________________________________
// Improvement 2 :	Path Compression

//make the child directly access the parent
//used to minimize the height (time complexity as well)

int find(int parent[],int X){
    	//call for find func and union as well

   	// i is not the parent of 
	// itself, then i is not the 
	// representative of his set. So we 
	// recursively call Find on its parent
    	if(parent[X]!=X){
		//we direcly put the recursily called ans into parent of current X
		//parent[X] contains the representive of this set directly
		parent[X]=find(parent,parent[X]);
    	}

	// If i is the parent of itself
	return parent[X];
}
