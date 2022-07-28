// Geek and knots - https://practice.geeksforgeeks.org/problems/little-murph-and-knots0402/1

static long dp[][]=new long[1001][1001];
static int mod=1_000_000_000+7;
static int knots(int M, int N, int K){
    long a=comb(M,K);
    long b=comb(N,K);
    return (int)( a%mod * b%mod )%mod;
}
// nCr = n-1Cr + n-1Cr-1;
static long comb(int n, int r){
    if(r==0 || n==r)    return 1;
    if(dp[n][r]!=0)     return dp[n][r];
    return dp[n][r] = ( comb(n-1,r) + comb(n-1,r-1) )%mod;
}

________________________________________________________________________________________________________________________________________________________________
//approach 2

static int knots(int M, int N, int K){
    int mod=1_000_000_000+7;
    int a=nCrModpLucas(M, K, mod);
    int b=nCrModpLucas(N, K, mod);
    return moduloMultiplication(a,b,mod);
}
static int moduloMultiplication(int a, int b, int mod){
         
    // Initialize result
    int res = 0; 

    // Update a if it is more than
    // or equal to mod
    a %= mod;

    while (b > 0)
    {

        // If b is odd, add a with result
        if ((b & 1) > 0)
        {
            res = (res + a) % mod;
        }

        // Here we assume that doing 2*a
        // doesn't cause overflow
        a = (2 * a) % mod;

        b >>= 1; // b = b / 2
    }
    return res;
}

static int nCrModpDP(int n, int r, int p){

    // The array C is going to store last row of
    // pascal triangle at the end. And last entry
    // of last row is nCr
    int[] C=new int[r+1];
 
    C[0] = 1; // Top row of Pascal Triangle
 
    // One by constructs remaining rows of Pascal
    // Triangle from top to bottom
    for (int i = 1; i <= n; i++)
    {
        // Fill entries of current row using previous
        // row values
        for (int j = Math.min(i, r); j > 0; j--)
 
            // nCj = (n-1)Cj + (n-1)C(j-1);
            C[j] = (C[j] + C[j-1])%p;
    }
    return C[r];
}
 
// Lucas Theorem based function that returns nCr % p
// This function works like decimal to binary conversion
// recursive function. First we compute last digits of
// n and r in base p, then recur for remaining digits
static int nCrModpLucas(int n, int r, int p){
  
  // Base case
  if (r==0)
      return 1;

  // Compute last digits of n and r in base p
  int ni = n%p;
  int ri = r%p;

  // Compute result for last digits computed above, and
  // for remaining digits. Multiply the two results and
  // compute the result of multiplication in modulo p.
  return (nCrModpLucas(n/p, r/p, p) * // Last digits of n and r
          nCrModpDP(ni, ri, p)) % p; // Remaining digits
}
