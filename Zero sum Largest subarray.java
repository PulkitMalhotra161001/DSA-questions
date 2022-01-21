int maxLen(int arr[], int n){
        
      Map<Integer,Integer> s=new HashMap<>();
      int sum=0,ans=0;
      s.put(0,-1);
      for(int i=0;i<arr.length;i++){
          sum+=arr[i];
          if(s.containsKey(sum))
              ans=Math.max(i-s.get(sum),ans);
          else
              s.put(sum,i);
      }
      return ans;
    
}
