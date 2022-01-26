// Gadgets of Doraland _ GFG
ArrayList<Integer>TopK(ArrayList<Integer> did, int k)
    {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<did.size();i++){
            m.put(did.get(i),1+m.getOrDefault(did.get(i),0));
        }
        
        List<Map.Entry<Integer,Integer>> l=new ArrayList<>(m.entrySet());
        Collections.sort(l,(o1,o2)->o2.getKey().compareTo(o1.getKey())); //descending keys
		Collections.sort(l,(o1,o2)->o2.getValue().compareTo(o1.getValue())); // descending values
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=0;i<k;i++) {
			ans.add(l.get(i).getKey());
		}
		return ans;
    }
