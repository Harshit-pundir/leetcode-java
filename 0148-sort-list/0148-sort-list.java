class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left,right);
    }
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
     }

    public ListNode merge(ListNode headA, ListNode headB) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(headA != null && headB != null){
            if(headA.val < headB.val){
                tail.next = headA;
                headA = headA.next;
            }else{
                tail.next = headB;
                headB = headB.next; 
            }

            tail = tail.next;
        }

        if(headA != null) tail.next = headA;
        if(headB != null) tail.next = headB;

        return dummy.next;
       }

}