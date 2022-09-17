class Solution{
    public:
    int findPlatform(int arr[], int dep[], int n)
    {
        sort(arr,arr+n);
        sort(dep,dep+n);
        // assume given array is this
        int count=1, ans=1, i=1, j=0;
        // i for arrival time and j for departure time
        while(i<n && j<n){
            //if arrival time is smaller than departure time means trains haven't leave the paltform
            if(arr[i]<=dep[j]){
                // so we need one more
                count++;
                i++;
            }else{
                //means we can use the empty platform
                count--;
                //j is now pointing to next departure time
                j++;
            }
            ans=max(ans,count);
        }
        return ans;
    }
    
    // static bool sortbysec(const pair<int,int> &a,const pair<int,int> &b){
    //     return a.second < b.second;
    // }
    
    // int findPlatform(int arr[], int dep[], int n)
    // {
    // 	vector<pair<int,int>> v;
    //     for(int i=0;i<n;i++){
    //         v.push_back(make_pair(arr[i],dep[i]));
    //     }
//     sort according to arrival time
    //     sort(v.begin(), v.end());
//     minimum heap
    //     priority_queue<int,vector<int>,greater<int>> pq;
    //     for(auto i:v){
//     if arrival time is smaller than minium or equal to departure time means we need one more platform
    //         if(pq.empty() || i.first<=pq.top()){
    //             pq.push(i.second);
//      means last departure time is smaller means trains leaves the platform we can use it noe
    //         }else{
    //             pq.pop();
    //             pq.push(i.second);
    //         }
    //     }
    //     return pq.size();
    // }
};
