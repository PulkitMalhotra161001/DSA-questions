//2262 - leetcode

// The appeal of a string is the number of distinct characters found in the string.
// For example, the appeal of "abbca" is 3 because it has 3 distinct characters: 'a', 'b', and 'c'.
// Given a string s, return the total appeal of all of its substrings.
// A substring is a contiguous sequence of characters within a string.


// What is the appeal of all substrings that end at i-th position?

// It is the same as the appeal of all substrings that end at i - 1 position, plus:
// number of substrings (ending at i-th position) that do not contain s[i] character.
// to count those substrings, we just track the previous (prev) position of s[i] character.

class Solution {
    public long appealSum(String s) {
        //i-1 contains in cur (outside loop)
        long cur=0, ans=0, n=s.length(), prev[]=new long[26];
        
        for( int i = 0 ; i < n ; i++ ){
            // Since we initialize last with zero, we need to do + 1
            cur += i + 1 - prev[s.charAt(i) - 'a'];
            prev[s.charAt(i) - 'a'] = i + 1;
            ans += cur;
            System.out.println("i:"+i+" -> "+ans+" "+cur);
        }
        
        return ans;
    }
}
        /*            "abbca"             */
//idx      0       1       2       3       4
//str      a       b       b       c       a
//cur      1       3       4       8       12
//ans      1       4       8       16      28
