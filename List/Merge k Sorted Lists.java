/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)   
            return null;
        return mergeSort(lists, 0, lists.length-1);
    }
    
    ListNode mergeSort(ListNode[] A, int left, int right) {
        if(left == right)
            return A[left];
        int mid = (left + right)/2;
        ListNode x = mergeSort(A, left, mid);
        ListNode y = mergeSort(A, mid+1, right);
        return mergeList(x, y);
    }

    ListNode mergeList(ListNode h1, ListNode h2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode temp = dummyhead;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }
            else {
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }

        if(h1 != null)
            temp.next = h1;
        else
            temp.next = h2;
        return dummyhead.next;
    }
}
