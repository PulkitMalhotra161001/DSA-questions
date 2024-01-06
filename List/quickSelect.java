// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
class Solution{
    // https://www.youtube.com/watch?v=XEmy13g1Qxc
    public  int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        return quickSelect(arr,r+1,k-1,l,r);
    } 
    static int quickSelect(int a[],int n,int k,int i,int j){
        // if(i==j)    return a[i];
        //in this we are taking pivot as the last index
        //w.r.t. pivot position we are identifying our kth value
        int pp = pivotPosition(a,n,i,j);
        // print(a);
        if(pp==k)   return a[k];
        else if(pp<k)   return quickSelect(a,n,k,pp+1,j);
        return quickSelect(a,n,k,i,pp-1);
    }
    static void print(int a[]){
        for(int i:a)    System.out.print(i+" ");
        System.out.println();
    }
    static int pivotPosition(int a[],int n,int l,int r){
        int p=l, pivot = a[r];
        //traversing till end to put smaller value in left of pivot and 
        //larger will be in right side (automatically)
        for(int i=l;i<r;i++){
            if(a[i]<=pivot){
                swap(a,p,i);
                p++;
            }
        }
        //swap to put pivot in the right position
        //bcz left is smaller than pivot and right is bigger
        swap(a,p,r);
        return p;
    }
    static void swap(int a[],int x,int y){
        int temp = a[x];
        a[x]=a[y];
        a[y]=temp;
    }
}
