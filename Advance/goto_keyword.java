//java doesn't support goto keyword. But it supports labelling.

____________________________________________________
public static void main(String[] args){

// label for outer loop
outer:
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 1)
                break outer;
            System.out.println(" value of j = " + j);
        }
    } // end of outer loop
}

//Output: value of j = 0
____________________________________________________
public static void main(String[] args){

// label for outer loop
outer:
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (j == 1)
                continue outer;
            System.out.println(" value of j = " + j);
        }
    } // end of outer loop
}

/*Output: 
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0
value of j = 0*/
____________________________________________________
search: for (String a: A) {
    int[] aCount = count(a);
    for (int i = 0; i < 26; ++i)
        if (aCount[i] < bmax[i])
            continue search;
    ans.add(a);
}
//Problem: https://leetcode.com/problems/word-subsets/editorial/
