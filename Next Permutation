static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> l=new ArrayList<>();
        int k=-1;
            
        for(int i=0;i<N-1;i++){
            if(arr[i]<arr[i+1])
                k=i;
        }
        if(k==-1){
            for(int i=N-1;i>=0;i--){
                l.add(arr[i]);
            }
            return l;
        }
        else{
            int x=k+1;
            for(int i=k+1;i<N;i++){
                if(arr[k]<arr[i])
                   x=i; 
            }
            
            int temp=arr[x];
            arr[x]=arr[k];
            arr[k]=temp;
            
            for(int i=0;i<=k;i++){
                l.add(arr[i]);
            }
            
            for(int i=N-1;i>k;i--){
                l.add(arr[i]);
            }
            return l;
            
        }
    }
