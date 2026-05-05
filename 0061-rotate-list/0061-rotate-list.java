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
    public ListNode rotateRight(ListNode head, int k) {
        // public → accessible everywhere
        // ListNode → return type (we return new head of linked list)
        // head → starting node of list
        // k → number of rotations

        // ---------- EDGE CASE ----------
        if (head == null || head.next == null) {
            // head == null → empty list
            // head.next == null → only 1 node
            return head;  // no rotation needed
        }

        // ---------- STEP 1: FIND LENGTH ----------
        int length = 1;           // start from 1 because head already counted
        ListNode tail = head;     // pointer to traverse list

        while (tail.next != null) {
            // tail.next != null → loop until last node
            tail = tail.next;     // move forward
            length++;             // increase count
        }

        // ---------- STEP 2: OPTIMIZE K ----------
        k = k % length;
        // WHY? rotating full length gives same list

        if (k == 0) {
            return head; // no change needed
        }

        // ---------- STEP 3: MAKE CIRCULAR ----------
        tail.next = head;
        // last node now points to head → circular linked list

        // ---------- STEP 4: FIND NEW TAIL ----------
        int steps = length - k;
        // new tail position

        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            // move (steps-1) times
            newTail = newTail.next;
        }

        // ---------- STEP 5: BREAK THE CIRCLE ----------
        ListNode newHead = newTail.next;
        // next node becomes new head

        newTail.next = null;
        // break the circle → now it's a proper list

        return newHead;
        // return rotated list
    }
}