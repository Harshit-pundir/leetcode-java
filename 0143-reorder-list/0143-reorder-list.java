class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return ;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second != null){
            ListNode firstNext = first.next;
            first.next = second;
            first = firstNext;

            ListNode secondNext = second.next;
            second.next = first;
            second = secondNext;
        }
    }
}