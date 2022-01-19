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

// ArrayList<Long> nthRowOfPascalTriangle(int n) {
// 	if(n==1){
// 	    ArrayList<Long> al=new ArrayList<>();
// 	    al.add(1L);
// 	    return al;
// 	}
//         ArrayList<Long> prev_list=nthRowOfPascalTriangle(n-1),curr_list=new ArrayList<>();
			
// 	for(int j=0;j<n;j++) {
//             if(j==0 || j==n-1)
//                 curr_list.add(1L);
//             else
// 		curr_list.add((prev_list.get(j)+prev_list.get(j-1))%1000000007);
// 	}
//         return curr_list;
// }
