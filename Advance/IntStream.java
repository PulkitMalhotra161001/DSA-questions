public static void main(String[] args) {
		int a[]= {1,2,3,4,5};
		System.out.println(Arrays.toString(a));
		int index=3;
		int new_a[]=IntStream.range(0, a.length).filter(i->i!=index).map(i->a[i]).toArray();
		System.out.println(Arrays.toString(new_a));
	} 
