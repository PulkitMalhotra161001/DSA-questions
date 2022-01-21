public static long findSubarray(long[] arr ,int n){
        Map<Integer,Integer> m=new HashMap<>();
        int count=0, sum=0;
        m.put(0,1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            count+=m.getOrDefault(sum,0); // if we have to find sum=k then " count+=m.getOrDefault(sum-k,0); "
            m.put(sum,1+m.getOrDefault(sum,0));
        }
        return count;
}
