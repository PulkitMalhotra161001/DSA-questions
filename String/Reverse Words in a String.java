  class Solution {
    public String reverseWords(String s) {
        int i=s.length()-1;
        StringBuilder sb=new StringBuilder();
        while(i>=0){
            while(i >= 0 && s.charAt(i)==' ') i--;
            int j=i;
            if(i<0) break;
            while(i>= 0 && s.charAt(i)!=' ') i--;
            if(sb.length()==0){
                sb.append(s.substring(i+1,j+1));    
            } else {
                sb.append(" "+s.substring(i+1,j+1));
            }
        }
        
        return sb.toString();
    }
}
