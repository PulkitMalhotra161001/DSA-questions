
return ( n>0 ) && (( n & (n-1))==0 ) && ( (n & 0xaaaaaaaa)==0);
 // check positive && check n is even && divisible by 4
// 0xaaaaaaaa is 1010 1010 1010 1010 1010 1010 1010 1010
//divisible by 4 means                      16=0001|0100=4
