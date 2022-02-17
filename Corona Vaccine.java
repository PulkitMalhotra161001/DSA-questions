class Solution{
    static int count;
    public static int supplyVaccine(Node root){
        count=0;
        if(solution(root)==-1)
            return count+1;
        return count;
    }
    public static int solution(Node root){
        if(root==null){
            return 1;
        }
        int left=solution(root.left);
        int right=solution(root.right);
        if(left==-1 || right==-1){
            count++;
            return 0;
        }
        if(left==0 || right==0){
            return 1;
        }
        return -1;
    }
}
