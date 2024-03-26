int computeXOR(int n) 
{ 
    // If n is a multiple of 4 
    if (n % 4 == 0) 
        return n; 
   
    // If n%4 gives remainder 1 
    if (n % 4 == 1) 
        return 1; 
   
    // If n%4 gives remainder 2 
    if (n % 4 == 2) 
        return n + 1; 
   
    // If n%4 gives remainder 3 
    return 0; 
} 

/*
1 -> 1 -> 1
2 -> 1^2 -> 3
3 -> 1^2^3 -> 0
4 -> 1^2^3^4 -> 4

5 -> 1^2^3^4^5 -> 1
6 -> 1^2^3^4^5^6 -> 7
7 -> 1^2^3^4^5^6^7 -> 0
8 -> 1^2^3^4^5^6^7^8 -> 0
  
9 -> 1^2^3^4^5^6^7^8^9 -> 1
*/
