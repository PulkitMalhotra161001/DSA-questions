// https://practice.geeksforgeeks.org/problems/brain-game1742/1#

public boolean brainGame(int[] nums)
    {
        int factors[]=new int[1001];
        for(int i=2;i<=1000;i++){
            //we have to change non-primes (they have factors)
            if(!prime(i)){
                //-1 bcz we have to change it to some other number
                factors[i]=factors_func(i)-1;
            }
        }
        int ans=0;
        for(int num:nums){
            //if a have nothing to change (all pairs factors cancel each other)
            ans^=factors[num];
            System.out.println(num+":"+factors[num]);
        }
        //a have nothing to change so a loss
        return ans==0?false:true;
    }
    public int factors_func(int n){
        int i=2;
        int ans=0;
        while(n%i==0){
            ans++;
            n/=i;
        }
        i++;
        for(;i<=Math.sqrt(n);i+=2){
            while(n%i==0){
                ans++;
                n/=i;
            }
        }
        if(n>2){
            ans++;
        }
        return ans;
    }
    public boolean prime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
