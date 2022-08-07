int maxLength(String S){
    int n=S.length();
    int dp[]=new int[n];
    int ans=0;
    for(int i=0;i<n;i++){
        int prev_res=0;

        //longest incr. subseq at i (taking ith value into consideration)
        for(int j=0;j<i;j++){

            //piche jitne value's (ith value se chote)
            if(S.charAt(j)<S.charAt(i))

                //unme se maximum ans kaha mil raha tha
                prev_res=Math.max(dp[j],prev_res);
        }

        //ye value le li (consideration)
        dp[i]=prev_res+1;

        //maximum value kahi bhi ho skte h
        ans=Math.max(dp[i],ans);

        // System.out.print(dp[i]+" ");
    }

    // System.out.println();
    //zaruri nhi ki last me ho 
    // e.g. 17 23 34 99 1
    // dp   1  2  3  4  1

    return ans;
}

// T.C = O(|S|²)

______________________________________________________________________________________________________________________________________________________________

int maxLength(String S){
    int n=S.length();
    Vector<Character> v=new Vector<>();
    v.add(S.charAt(0));
    for(int i=1;i<n;i++){
        char c=S.charAt(i);
        if(c>v.lastElement())
            //no is larger we can insert
            v.add(c);
        else{
            //find no. biggest value in vector and put char
            v.set(find_ceil(v,c) ,c);
        }
    }
    //vector is not the resultant subseq, it is just the result
    return v.size();
}
int find_ceil(Vector<Character> v,char x){
    int l=0, r=v.size()-1;
    while(l<r){
        int mid=l+(r-l)/2;
        if(v.get(mid)>=x){
            r=mid;
        }else{
            l=mid+1;
        }
    }
    return l;
}

//T.C. = O(n*logn)
