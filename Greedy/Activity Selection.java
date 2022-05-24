class Solution
{
    public static int activitySelection(int start[], int end[], int n)
    {
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=start[i];
        }
        for(int i=0;i<n;i++){
            arr[i][1]=end[i];
        }
        
        //sort by starting position
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        int i=0;
        int s=-1;
        int ans=0;
        while(i<n){
            if(s<arr[i][0]){
                s=arr[i][1];
                ans++;
            }
            i++;
        }
        return ans;
    }
}
