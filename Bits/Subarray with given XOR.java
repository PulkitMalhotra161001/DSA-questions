// https://www.interviewbit.com/problems/subarray-with-given-xor/

public int solve(ArrayList<Integer> A, int B) {
        Map<Integer,Integer> map=new HashMap<>();
        int xor=0, ans=0;
        for(Integer i:A){
            xor^=i;
            if(xor==B)  ans++;
            if(map.containsKey(xor^B))  ans+=map.get(xor^B);
            map.merge(xor,1,Integer::sum);
        }
        return ans;
    }
