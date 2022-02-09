class Compute  
{ 
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        //lambda function
        //comparator function comapre
        //decending order
        Arrays.sort(arr, (x,y)->Integer.compare(Integer.bitCount(y), Integer.bitCount(x)));
    }
}
