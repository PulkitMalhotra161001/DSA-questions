static int count(int N){
        return catalan(N/2);
    }
    static int catalan(int n){
        if(n<=1)
            return 1;
        int a=0;
        for(int i=0;i<=n-1;i++){
            a+=catalan(i)*catalan(n-1-i);
        }
        return a;
    }
