class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        List<int[]> ans=new ArrayList<>();
        
        ans.add(intervals[0]);
        
        for(int i=1;i<intervals.length;i++){
            int out_l=ans.get(ans.size()-1)[1];
            int int_f=intervals[i][0];
            if(out_l>=int_f){
                int min=Math.min(ans.get(ans.size()-1)[0],int_f);
                int max=Math.max(out_l,intervals[i][1]);
                ans.remove(ans.size()-1);
                int a[]={min,max};
                ans.add(a);
            }
            else if(out_l<int_f){
                ans.add(intervals[i]);                
            }
        }
        return ans.toArray(new int[ans.size()][]);
        
    }
}
