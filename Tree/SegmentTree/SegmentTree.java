//https://leetcode.com/problems/range-sum-query-mutable/
class NumArray {
    ST tree;
    public NumArray(int[] nums) {
        tree = new ST(nums, nums.length);
    }
    
    public void update(int index, int val) {
        tree.update(index,val);
    }
    
    public int sumRange(int left, int right) {
        return tree.getSum(left,right);
    }
}

class ST{
    
    int st[], a[];
    int n;
    
    ST(int a[],int n){
        // int size = (int)Math.pow(2,n)-1;
        //reason for 4*n
        //https://leetcode.com/problems/range-sum-query-mutable/discuss/1247355/Java-Simple-and-easy-using-Segment-Tree-solution-clean-code-with-comments/980720
        st = new int[4*n];
        this.n=n;
        this.a=a;
        construct(n,0,0,n-1);
    }
    
    int construct(int n,int i,int l,int r){
        //leaf node
        if(l==r){
            st[i]=a[l];
            return st[i];
        }
        int mid = l+(r-l)/2;
        //interior node value will be sum of left and right node value's
        return st[i] = construct(n,2*i+1,l,mid) + construct(n,2*i+2,mid+1,r);
    }
    
    int getSum(int l,int r){
        return getSum(0,0,n-1,l,r);
    }
    
    //find sum of range (l,r)
    int getSum(int i,int sl,int sr,int l,int r){
        //complete overlap
        if(l<=sl && sr<=r)  return st[i];
        //no overlap (left side or right side)
        if(sr<l || sl>r)    return 0;
        //partial overlap - traverse both sides
        int mid = sl+(sr-sl)/2;
        return getSum(2*i+1,sl,mid,l,r) + getSum(2*i+2,mid+1,sr,l,r);
    }
    
    void update(int i,int val){
        //find diff and change node value's
        int diff = val-a[i];
        a[i]+=diff;
        updateOther(i,0,0,n-1,diff);
    }

    //change value of id index value
    void updateOther(int id,int i,int sl,int sr,int diff){
        if(sl<=id && id<=sr)  st[i]+=diff;
        //leaf node
        if(sl==sr)  return;
        int mid = sl+(sr-sl)/2;
        //node lies in left side
        if(id<=mid)  updateOther(id,2*i+1,sl,mid,diff);
        //lies right side
        else updateOther(id,2*i+2,mid+1,sr,diff);
    }
    
    void print(){
        for(int i:st){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
}

//other problem: Min-Max Range Queries in Array
