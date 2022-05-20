class Solution {
    public int firstUniqChar(String s) {
        int ans[]=new int[26];
		Arrays.fill(ans, 0);

        for(int i=0;i<s.length();i++) {
		char c=s.charAt(i);
		ans[(int)c-97]++;
	}
        
        for(int i=0;i<s.length();i++) {
		char c=s.charAt(i);
		if(ans[(int)c-97]==1)
                	return i;
	}
        return -1;
    }
}
