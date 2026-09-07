class Solution {
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = slow;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode after = null;

        while(curr != null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode ptr1 = head;
        ListNode temp = middle(head);
        ListNode ptr2 = reverse(temp);

        int sum = 0;
        while(ptr2 != null){
            if(sum < (ptr1.val + ptr2.val)){
                sum = ptr1.val + ptr2.val;
            }
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        return sum;
    }
}