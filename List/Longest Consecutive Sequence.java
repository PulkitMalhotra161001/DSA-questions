public int longestConsecutive(final List<Integer> A) {
        Collections.sort(A);
        int ans=0;
        int curr=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)==A.get(i-1))
                continue;
            if(A.get(i)-1==A.get(i-1)){
                curr++;
            }
            else{
                ans=Math.max(curr,ans);
                curr=1;
            }
        }
        return Math.max(curr,ans);
    }
