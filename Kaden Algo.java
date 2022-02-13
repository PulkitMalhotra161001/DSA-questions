//flip - iB
//0 1 0 0 0 0
//1 -1 1 1 1
public class Solution {
    public ArrayList<Integer> flip(String A) {
        int curr = 0,max = 0,temp_start =0 , start = 0,end = 0;
        for(int i=0;i<A.length();i++){
            int v=A.charAt(i)=='1'?-1:1;
            curr+=v;
            if(max<curr){
                max = curr;
                end = i;
                start = temp_start;
            }
            if(curr<0){
                curr  = 0;
                temp_start = i+1;
            }
        }

        ArrayList<Integer> al=new ArrayList<>();
        if(max>0){
            al.add(start+1);
            al.add(end+1);
        }
        return al;
        
    }
}
