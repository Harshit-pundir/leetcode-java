class Solution {
    public int sizeCount(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1) return null;
        int size = sizeCount(head);
        int need = size-n;

        if(need == 0) return head.next; 
        int count = 0;

        ListNode temp = head;
        while(temp != null && count != need-1){
            temp = temp.next;
            count++;
        }

        if(temp == null || temp.next == null) return head;
        temp.next = temp.next.next;
        return head;
    }
}