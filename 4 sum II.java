public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        HashMap<Integer,Integer> s=new HashMap<>();
        int n=a.length;
        for(int i:a){
            for(int j:b){
                int sum=i+j;
                s.put(sum,1+s.getOrDefault(sum,0));
            }
        }
        int ans=0;
        for(int i:c){
            for(int j:d){
                int sum_inv=i+j;
                ans+=s.getOrDefault(-sum_inv,0);
            }
        }
        return ans;
    }
