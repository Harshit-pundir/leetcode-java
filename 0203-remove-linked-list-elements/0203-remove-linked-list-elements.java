class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        while(temp != null){
            while(temp.next != null && temp.next.val == val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        if(head != null && head.val == val) return head.next;
        return head;
    }
}