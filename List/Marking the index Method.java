//https://practice.geeksforgeeks.org/problems/elements-in-the-range2834/1

boolean check_elements(int arr[], int n, int A, int B)
{
    //not enough value's 
    if(n<=B-A)   return false;

    for(int i=0;i<n;i++){
        //bcz value may be marked
        if(A<=Math.abs(arr[i]) && Math.abs(arr[i])<=B){

            //mark the index (this will be in the range of 0 to B-A)
            int id = Math.abs(arr[i])-A;

            //only if index is not already marked
            if(arr[id]>0)
                arr[id]*=-1;
        }
    }

    // 1  4  5  2 7 8 3
    //-1 -4 -5 -2 7 8 3
    for(int i:arr)
        System.out.print(i+" ");

    for(int i=0;i<=B-A;i++){
        //if index is not marked means i+A value not +nst
        if(arr[i]>0)    return false;
    }
    return true;
}
