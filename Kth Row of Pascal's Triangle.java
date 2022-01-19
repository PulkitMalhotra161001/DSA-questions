public class Solution {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> res = new ArrayList<>(a+1);
        res.add(1);
        if(a==0)
            return res;
        for(int i=1; i<a; i++){
	        int num = (a+1-i)*res.get(i-1)/i;
            res.add(num);
	    }
        res.add(1);
	    return res;
    }
}
