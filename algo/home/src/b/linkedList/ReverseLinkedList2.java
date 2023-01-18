package b.linkedList;


/** class ListNode {
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

public class ReverseLinkedList2 {

    // Recursive Approach
    // ** Not using this approach because of Backtracking
    // Time Complexity: O(N) - Process all the nodes at most twice
    // Space Complexity: O(N) - Space occupied by the recursion stack



    // Iterative Approach
    // Time Complexity: O(N) - we have to iterate through all n nodes
    // Space Complexity: O(1) - We are not creating new data proportional to size of list

    // ** Intuition
    // ** Just like we did for ReverseLinkedList. First we change the pointers of each node to point to the node before it
    //  This way, we have the method to reverse the list.
    // Then we return the final node as the head node

    // STEP 1: Here, first we need a way to get to the first node of the sub-list to reverse
    // what we need to do is iterate up to our left index which is the start of the sub-list

    // STEP 2: we then make all the nodes point to the node before them, (like we did for ReverseLinkedList)
    // until we have reached our right index, and then we stop

    // STEP 4: we need to fix where the node before the reversed sub-list is pointing to
    // The node now points to the end of the reversed sublist (which used to be the start).
    // It should point to the head of the reversed sub-list
    // ** Now we point to the new start of the sub-list

    // STEP 5: Similarly, the last node of the reversed sublist should now point to the node after the sub-list
    // STEP 6: We then return the head of the list we've been given


    public ListNode reverseBetween(ListNode head, int left, int right) {

        // head is null or left index is same as right index (i.e. the list doesn't change), return head
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // create a dummy node just before the start/head
        ListNode dummy = new ListNode(0, head);

        ListNode before = dummy;

        // we iterate the linkedList up to the node before the first node of the sublist we want to reverse
        // *** starting from 1 because the linkedList starts from 1 and not 0
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        // keep pointers for the current node and the node before it
        ListNode prev = before;

        // Current node will be the start of the list we want to reverse
        ListNode current = before.next;

        // we then reverse the list we are interested in (implementation is similar to the regular linked list reversal)
        for (int i = left; i <= right; i++) {

            // we store the next variable before we overwrite it
            ListNode next = current.next;

            // overwrite it with the prev. node
            current.next = prev;

            // move previous and current up one node until they reach the right index
            // re-assign previous node to become the current node
            prev = current;

            // the current node now becomes the next node we stored in a variable
            current = next;
        }


        // Next, we need to correct our remaining pointers
        // before.next is now the end of the sublist,
        // it needs to now point to the node after the sublist (i.e. current)
        before.next.next = current;

        // before.next now points to previous which is the first node of the sublist
        before.next = prev;

        // we return the head
        return dummy.next;
    }


}
