ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

//lexicographical order.
Collections.sort(ans,(o1,o2)->{
    int i=0;
    for(;i<Math.min(o1.size(),o2.size());i++){
        if(o1.get(i)==o2.get(i)){
            continue;
        }
        if(o1.get(i)<o2.get(i)){
            return -1;
        }
        return 1;
    }
    if(i<o1.size()){
        return 1;
    }
    if(i<o2.size()){
        return -1;
    }
    return 0;
});


_____________________________________________________________________________________________________________________________________________________________________

//Subsets - gfg

class Solution
{
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        premu(A,new ArrayList<>(),0,ans);
        
        Collections.sort(ans,(o1,o2)->{
            int i=0;
            for(;i<Math.min(o1.size(),o2.size());i++){
                if(o1.get(i)==o2.get(i)){
                    continue;
                }
                if(o1.get(i)<o2.get(i)){
                    return -1;
                }
                return 1;
            }
            if(i<o1.size()){
                return 1;
            }
            if(i<o2.size()){
                return -1;
            }
            return 0;
        });
        
        // Collections.sort(ans, (o1, o2) -> {
        //     int n = Math.min(o1.size(), o2.size());
        //     for (int i = 0; i < n; i++) {
        //         if (o1.get(i) == o2.get(i)){
        //             continue;
        //         }else{
        //             return o1.get(i) - o2.get(i);
        //         }
        //     }
        //     return 1;
        // });
        
    //     Collections.sort(ans,new Comparator<ArrayList<Integer>>(){
    //         public int compare(ArrayList<Integer> p, ArrayList<Integer> q){
    //             int i = 0;
    //             while(i < Math.min(p.size(), q.size())){
    //                 if(p.get(i) == q.get(i)){
    //                     i++;
    //                     continue;
    //                 }
    //                 if(p.get(i) < q.get(i)){
    //                     return -1;
    //                 }
    //                 return 1;
    //             }
    //             if(i < q.size()){ 
    //                 return -1;
    //             }
    //             if(i < p.size()){
    //                 return 1;
    //             }
    //             return 0;
    //         }
    //   });
        
        return ans;
    }
    public static void premu(ArrayList<Integer> A,ArrayList<Integer> temp,int si,ArrayList<ArrayList<Integer>> ans){
        if(si==A.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        premu(A,new ArrayList<>(temp),si+1,ans);
        temp.add(A.get(si));
        premu(A,new ArrayList<>(temp),si+1,ans);
        // temp.remove(temp.size()-1);
    }
}
