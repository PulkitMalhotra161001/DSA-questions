class Solution {
    public String reverseWords(String s) {
        
        if(s==null && s.length()<=1)
            return s;
        char c[]=s.toCharArray();
        int n=c.length, j=0;
        for(int i=0;i<=n;i++){
            if(i==n || c[i]==' '){
                reverse(c,j,i-1);
                j=i+1;
            }
        }
        return new String(c);
    }
    
    public void reverse(char s[], int i, int j){
        while(i<j){
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
    }
}

//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
