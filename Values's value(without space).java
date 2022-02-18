// Rearrange Geek and his Classmates - GFG
void prank(long[] a, int n)  
{ 
    long N = n;
    for(int i = 0;i<n;i++){
        a[i] = a[i] + (a[(int )a[i]]%N) * N;
    }

    for(int i = 0;i<n;i++)
        a[i] = a[i]/N;
}
