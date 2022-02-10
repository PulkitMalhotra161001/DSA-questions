class Solution{
    static int xorCal(int k){
        if(k==1)
            return 2;
        //if we have prime no. then ans is k/2 but we have one more case
        //if k==5 then ans is -1
        //for 7 we have 111 and for 5 we have 101
        //we can conclude that if we have atleast one '0' bit then ans is -1
        //for 7=111 we created a mask 1000 the we take '&' if it is 0 then our ans is n/2
        //in case of 5=101 we have mask 110 if we take '&' our ans is always >0 bcz out lsb shifted from 1 to 2 
        else if(((k+1) & k)==0)
            return k/2;
        return -1;
        //another way of saying
        //if k is even then k+1 is odd, we have xor '>0' (lsb==1)
    }
}
