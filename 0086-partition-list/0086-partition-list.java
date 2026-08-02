class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(0);

        ListNode small = s1;
        ListNode large = s2;

        while(head != null){
            if(head.val <  x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }
        large.next = null;
        small.next = s2.next;
        return s1.next;
    }
}