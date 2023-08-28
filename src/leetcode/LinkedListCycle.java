package leetcode;

//https://foxtrot.tistory.com/21
public class LinkedListCycle {
    private boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
            if (fast == null) return false;
        } while (slow != fast);

        return true;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
