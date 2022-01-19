class Solution {
    public boolean isValid(String st) {
        Stack<Character> s=new Stack<>();
        for(int i=0;i<st.length();i++){
            char c=st.charAt(i);
            
            if(c=='[' || c=='{' || c=='('){
                s.push(c);
                continue;
            }
            
            if(s.isEmpty())
                return false;
            
            if(c=='}'){
                if(s.peek()=='{'){
                    s.pop();
                    continue;
                }
                else
                    return false;
            }
            
            else if(c==']'){
                if(s.peek()=='['){
                    s.pop();
                    continue;
                }
                else
                    return false;
            }
            
            else{
                if(s.peek()=='('){
                    s.pop();
                    continue;
                }
                else
                    return false;
            }
            
        }
        
        if(s.isEmpty())
            return true;
        else 
            return false;
        
    }
}
