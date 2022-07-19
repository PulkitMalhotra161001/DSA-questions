// Count Smaller elements : https://practice.geeksforgeeks.org/problems/count-smaller-elements2214/1
int[] constructLowerArray(int[] arr, int n) {
        int ans[]=new int[n];
        List<Integer> list=new ArrayList<>();
        list.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            ans[i]=find(arr[i],list);
            list.add(ans[i],arr[i]);
        }
        return ans;
    }
    int find(int x,List<Integer> list){
        int i=0, j=list.size()-1;
        while(i<=j){
            int mid=j+(i-j)/2;
            if(list.get(mid)<x){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
