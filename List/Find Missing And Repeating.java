// https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

int[] findTwoElement(int arr[], int n) {
        int xor=0;
        for(int i:arr){
            xor^=i;
        }
        for(int i=1;i<=arr.length;i++){
            xor^=i;
        }
        int pos=0, x=xor;
        while((x&1)==0){
            x=x>>1;
            pos+=1;
        }
        // System.out.println(pos);
        int a=0, b=0;
        for(Integer i:arr){
            if(((i>>pos)&1)==1){
                // System.out.println("Hello "+i);
                a^=i;
            }
        }
        
        for(int i=1;i<=arr.length;i++){
            if(((i>>pos)&1)==1){
                // System.out.println("HI "+i);
                a^=i;
            }
        }
        int x_count=0;
        for(int i:arr){
            if(i==a){
                x_count++;
            }
        }
        if(x_count>0)   return new int[]{a,a^xor};
        return new int[]{a^xor,a};
    }
