class Solution {
    public static int minVal(int a, int b) {
        int bitA=Integer.bitCount(a);
        int bitB=Integer.bitCount(b);
        
        if(bitA==bitB){
            return a;
        }else if(bitA<bitB){
            while(bitA<bitB){
                //set least unset bit
                a|=a+1;
                bitA++;
            }
        }else{
            while(bitA>bitB){
                //unset least set bit
                a&=a-1;
                bitA--;
            }
        }
        
        return a;
    }
}
