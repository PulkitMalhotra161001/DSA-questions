//gfg

int swapBits(int x, int p1, int p2, int n)
    {
        //right shifted our (desired n length) binary (start with position p1)    =  0010111
        //'&' with all ones (get by doing n length shifted, 1000 and subtract 1)  =  0000111
        //                                                                      a =  0000111 
        int a=(x>>p1) & ((1<<n) - 1);
                                                            // (focus on last n length bits)
        //same goes for (position p2)                                             =  0000001
        //                                                                        =  0000111
        //                                                                      b =  0000001
        int b=(x>>p2) & ((1<<n) - 1);
                                                    // (n length c=110)         c =  0000110
        int c=( a^b );                              
                                       // (full c is c at position p1 and p2)   c =  1100110
        c=(c<<p1) | (c<<p2);
        // System.out.println(Integer.toBinaryString(c));
        // return 0;
        
        //xor with x
        
        //assume at position p1 (bits of n length) is a
        //assume at position p2 (bits of n length) is b
        //xor of a^c=b (c=a^b)
        
        //same goes for
        //xor of b^c=a (c=a^b)
        int ans=x^c;
        return ans;
    }
