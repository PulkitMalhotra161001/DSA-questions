// https://practice.geeksforgeeks.org/problems/heap-sort/1

class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        for(int i=n/2;i>=0;i--){
            heapify(arr,n,i);
        }
        
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int l=2*i+1, r=2*i+2, max=i;
        if(l<n && arr[l]>arr[max])  max=l;
        if(r<n && arr[r]>arr[max])  max=r;
        // System.out.println(l+" "+r+" "+i+" "+max);
        if(max!=i){
            swap(arr,i,max);
            heapify(arr,n,max);
        }
    }
    void swap(int a[],int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
    
    //Function to sort an array using Heap Sort. (main)
    public void heapSort(int arr[], int n)
    {
        // int b[]=new int[n+1];
        // for(int i=0;i<n;i++)    b[i+1]=arr[i];
        //step1 convert to heap
        buildHeap(arr,n);
        // for(int i:arr)    System.out.print(i+" ");
        // System.out.println();
        
        // remove max element which is topmost (heap is maxHeap)
        for(int i=n-1;i>=0;i--){
            // System.out.println(arr[0]);
            // arr[i-1]=arr[1];
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
 }
