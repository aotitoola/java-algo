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
}*/


public class AddTwoNumbers2 {


    // Approach:
    // Time Complexity: O(N1 + N2), where N! & N2 are the number of items in the list
    // Space Complexity: O(1), No additional space was used. As is the case for most linkedList problems


    // Algorithm:

    // In math, we start by summing the least significant digit
    // In the question, the most significant digit comes first for both lists
    // It will be easier to start summing from the least significant digit if we reverse the two lists first

    // when we are summing the nodes, we need to keep adding the current node to the front of our result

    // STEP 1: We implement Reverse List function
    // STEP 2: Reverse both input lists
    // STEP 3: We initialise 'head' to null and carry to be 0

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {

        // Reverse both input Lists
        node1 = reverseLinkedList(node1);
        node2 = reverseLinkedList(node2);

        // initialise 'head' to null and carry to be 0
        ListNode head = null;
        int carry = 0;

        // we iterate through while both the node in either list is not null
        while (node1 != null || node2 != null) {

            // next we get the current values of the nodes
            // either of the node can be null at any point, and we need to cater for that
            int v1 = node1 != null ? node1.val : 0;
            int v2 = node2 != null ? node2.val : 0;


            // next we calculate the current sum
            int sum = (v1 + v2 + carry) % 10;             // the remainder after dividing by 10 is what we need here

            // we then update the carry
            carry = (carry + v1 + v2) / 10;

            // when we are summing the nodes, we need to keep adding the current node to the front of our result
            // get a reference to the current node
            ListNode current = new ListNode(sum);
            current.next = head;
            head = current;


            // next we move to the next elements
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }


        // if at the end, the carry is not zero, we need to append it to the front of the list
        if (carry != 0) {
            ListNode current = new ListNode(carry) ;
            current.next = head;
            head = current;
        }


        // we return the head after
        return head;
    }


    public ListNode reverseLinkedList(ListNode head) {

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


