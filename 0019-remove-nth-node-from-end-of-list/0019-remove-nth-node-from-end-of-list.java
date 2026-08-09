class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

        if(head == null) return null;
        ListNode fast = dummy;

        for(int i =0; i<=n; i++){
            fast = fast.next;
        }

        ListNode slow = dummy;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}