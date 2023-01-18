package b.linkedList;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Initialize current node to dummy head of the returning list.
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        // Initialize carry to 0
        int carry = 0;

        // Loop through lists l1 and l2 until you reach both ends and crarry is 0.
        while (l1 != null || l2 != null || carry != 0) {

            // Set x to node l1's value. If l1 has reached the end of l1, set to 0
            int x = (l1 != null) ? l1.val : 0;

            // Set x to node l2's value. If l2 has reached the end of l2, set to 0
            int y = (l2 != null) ? l2.val : 0;

            // Set sum = x + y + carry
            int sum = x + y + carry;

            // Update carry = sum / 10
            carry = sum / 10;

            // Create a new node with the digit value of (sum mod 10) and set it to current node's             // next, then advance current node to next.
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // Advance both l1 and l2.
            if (l1 != null){
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }

        }

        // Return dummy head's next node.
        return dummyHead.next;
    }

}
