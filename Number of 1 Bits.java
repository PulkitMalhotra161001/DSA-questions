public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            //add last bit
            ones += (n & 1);
            //unsigned integer right shift
            n >>>= 1;
        }
        return ones;
        // return Integer.bitCount(n);
    }
}
