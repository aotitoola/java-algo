package b.linkedList;


/**
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
*/


public class MergeTwoSortedLists {

    // Iterative solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // keep track of the head of the new list, and the tail to add onto
        ListNode head = new ListNode(0);
        ListNode tail = head;

        // iterate until we reach the end of one list
        while(l1 != null && l2 != null) {
            // compare the head of both lists
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;

        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;

        // time complexity = O(m + n)
        // space complexity = O(1)  no extra space used
    }

    // Recursive solution
    //     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //         // base case
    //         // i.e. if we have reached the end of l1, return l2. To avoid null pointer exception.

    //         if (l1 == null) {
    //             return l2;
    //         }

    //         if (l2 == null) {
    //             return l1;
    //         }

    //         // compare the heads of l1 and l2
    //         ListNode head;

    //         if (l1.val < l2.val) {
    //             head = l1;
    //             l1 = l1.next;
    //         } else {
    //             head = l2;
    //             l2 = l2.next;
    //         }

    //         head.next = mergeTwoLists(l1, l2);

    //         return head;

    //         // time complexity = O(m + n)
    //         // space complexity = O(m + n) = no. of stack trace being used
    //     }

}
