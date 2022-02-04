/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node level=root;
        while(level!=null && level.left!=null){
            Node temp=level;
            while(true){
                temp.left.next=temp.right;
                if(temp.next==null){
                    break;
                }
                    
                temp.right.next=temp.next.left;
                temp=temp.next;
            }
            level=level.left;
        }
        return root;
    }
}
