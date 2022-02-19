class Solution {
	public List<List<Integer>> generate(int n) {
		List<List<Integer>> l = new ArrayList<>();
		List<Integer> prev_list = null, curr_list;

		for (int i = 0; i < n; i++) {
			curr_list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i)
					curr_list.add(1);
				else
					curr_list.add(prev_list.get(j) + prev_list.get(j - 1));
			}
			prev_list = curr_list;
			l.add(curr_list);
		}
		return l;
	}
}
