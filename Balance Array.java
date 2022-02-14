//iB
public class Solution {
    public int solve(ArrayList<Integer> A) {
        ArrayList<Integer> arr=A;
        int s1=0,s2=0,n=A.size(),s3=0,s4=0;
        for(int i=0;i<n;i++){
            if(i%2==0)
               s2+=arr.get(i);
           else
               s1+=arr.get(i);
        }
       int c=0;
       for(int i=0;i<n;i++){
            if(i%2==0){
                s2-=arr.get(i);
                if(s2+s4==s1+s3)
                    c+=1;
                s3+=arr.get(i);
            }
             else{
                 s1-=arr.get(i);
                 if(s2+s4==s3+s1)
                     c+=1;
                 s4+=arr.get(i);
             }
       }
       return c;
    }
}
