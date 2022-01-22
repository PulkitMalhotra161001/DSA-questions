public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int k=0;
        int l=0;
        ArrayList<Integer> res=new ArrayList<>();
        ArrayList<Integer> curr_list=A.get(0);
        int m=A.size()-1;
        int n=curr_list.size()-1;
        while(k<=m && l<=n){
            curr_list=A.get(k);
            for(int i=l;i<=n;i++){
                res.add(curr_list.get(i));
            }
            k++;
            for(int i=k;i<=m;i++){
                curr_list=A.get(i);
                res.add(curr_list.get(n));
            }
            n--;
            if(k<=m){
                for(int i=n;i>=l;i--){
                    res.add(curr_list.get(i));
                }
                m--;
            }
            if(l<=n){
                for(int i=m;i>=k;i--){
                    curr_list=A.get(i);
                    res.add(curr_list.get(l));
                }
                l++;
            }
        }
        return res;
    }
