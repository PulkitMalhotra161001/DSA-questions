// https://practice.geeksforgeeks.org/problems/31272eef104840f7430ad9fd1d43b434a4b9596b/1

ArrayList<Integer> search(String pat, String S)
    {
        int mod=1_000_000;
        ArrayList<Integer> list=new ArrayList<>();
        int p_code=0, s_code=0, sn=S.length(), pn=pat.length();
        
        // calculate most significant position
        // (we will need this when we have to remove most signicant position value)
        // The value of h would be "pow(d, M-1)%q"
        int till_b = 1; 
        for (int i = 0; i < pn-1; i++)
            till_b = (till_b*26)%mod;
        
        // System.out.println(h);

        for(int i=0;i<pn;i++){
            
            // pattern string hash
            p_code = ( p_code*26 + pat.charAt(i) ) % mod;
            
            // first window hash
            s_code = ( s_code*26 + S.charAt(i) ) % mod;
        }
        
        for(int i=pn;i<=sn;i++){
        
            // hash are equal
            if( p_code==s_code && S.substring(i-pn,i).equals(pat) )    list.add(i-pn+1);
            
            // rolling hash
            // remove a value from most significant position
            s_code=(s_code-S.charAt(i-pn)*till_b)%mod;
            // add new value to the least significant position
            if(i<sn)     s_code=( s_code*26 + S.charAt(i))%mod;
            if(s_code<0)     s_code+=mod;
        }
        
        if(list.isEmpty())  list.add(-1);
        return list;
    }
