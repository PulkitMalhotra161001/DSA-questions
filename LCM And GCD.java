static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans=new Long[2];
        ans[1]=gcd(A,B);
        ans[0]=(A*B)/ans[1];
        return ans;
    }
    
    static Long gcd(Long A, Long B){
        while(A%B!=0){
            Long rem=A%B;
            A=B;
            B=rem;
        }
        return B;
    }
