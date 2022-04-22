int sum(int a , int b)
    {
        int carry=a&b;
        int sum=a^b;
        while(carry>0){
            int shift=carry<<1;
            // System.out.println(carry+" "+shift);
            carry=shift&sum;
            sum=sum^shift;
        }
        return sum;
    }
