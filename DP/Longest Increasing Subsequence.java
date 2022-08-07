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
