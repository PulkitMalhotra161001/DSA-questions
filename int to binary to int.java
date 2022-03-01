int x=136;
String s=Integer.toBinaryString(x); //int to binary
System.out.println(s);
x=Integer.parseInt(s, 2); //binary to int
System.out.println(x);


//binary search
int id = Collections.binarySearch(a,b);
return id<0?-id-1:id;

//numbers of digits in int
System.out.println((int)Math.log10(324512)+1);
