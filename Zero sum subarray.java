static boolean findsum(int arr[],int n){
        Set<Integer> s=new HashSet<>();
        int ans=0;
        for(int i:arr){
            s.add(ans);
            ans+=i;
            if(s.contains(ans)) // if we have to find sum=k then if(s.contains(ans-k))
                return true;
        }
        return false;
}
