class GfG
{
	int find(int A[],int X){
	    if(A[X]==X){
	        return X;
	    }
	    return find(A,A[X]);
	}
	void unionSet(int A[],int X,int Z){
	    int x=find(A,X);
	    int z=find(A,Z);
	    if(x==z){
	        return;
	    }
	    A[x]=z;
	}
}
