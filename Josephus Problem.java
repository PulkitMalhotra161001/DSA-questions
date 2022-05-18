// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

class Solution {
    public int findTheWinner(int n, int k) {
/*      for ans we have to take the 0th value as 1 and 1th as 2 and so on..
        for that we incremented the index value*/
        return solve(n,k)+1;
    }
    public int solve(int n,int k){
/*      if length is 1 (minimum value) then the winner is 0th index

        otherwise call the function recursively but this time one value/person subtracted
        we incremented the k bcz the removal values is (k-1)th and the kth value will have the gun to shoot the next kth person
        
        %n is just for be in the range   */
        return  (n == 1) ? 0 : (solve(n-1,k)+k)%n;
    }
}

/* 
k=2
Diagram      1   2   3   4   5
Elements     5   4   3   2   1
Answer       2   0   2   0   0(filled from smaller n)(right->left)
we have 1 index so we have to increment our final answer
*/ 
