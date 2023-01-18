package b.linkedList;


/** class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/

public class ReverseLinkedList {

    // Recursive Approach
    // ** Not using this approach because of Backtracking
    // Time Complexity: O(N) - Process all the nodes at most twice
    // Space Complexity: O(N) - Space occupied by the recursion stack




    // Iterative Approach
    // Time Complexity: O(N) - we have to iterate through all n nodes
    // Space Complexity: O(1) - We are not creating new data proportional to size of list

    // To reverse this List we need to make every node somehow point to the node before it
    // Note: We do not have a way to access the previous node from the current node we are on
    // This is because every node points to the next node.

    // So we need to keep track of the previous node in some variable (let's call this variable previous)
    // then we make our node point to it as the next node

    // WE MUST ALSO SAVE THE NEXT NODE IN ANOTHER VARIABLE (let's call this variable next)
    // BEFORE WE OVERWRITE THE VALUE OF current.next

    // The new current node will now be what was saved in the NEXT variable

    // When the current node is null, we know we have reached the end of the list

    // Finally, the algorithm to make a node point to a previous node still works for the first node of the list
    // if the previous node is set to null, so we start with the previous node initially set to null;


    public static ListNode reverseLinkedList(ListNode head) {

        // the general idea here is to change which direction the nodes are pointing

        // STEP 1: previous node is initially set to null and
        // current node is set to head
        ListNode prev = null;
        ListNode current = head;

        // Iterate through the list until current is not null
        // because if we keep going, at some point current node will be null
        while (current != null) {

            // we store the next variable before we overwrite it
            ListNode next = current.next;
            // overwrite it with the prev. node
            current.next = prev;

            // re-assign previous node to become the current node
            prev = current;

            // the current node now becomes the next node we stored in a variable
            current = next;
        }

        // once we hit null., the previous node becomes the new head (last node in the list)
        return prev;
    }
}
