class Solution {
    public int sizeCount(ListNode head){
        int size = 0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        int size = sizeCount(temp);
        k = k % size;

        if(k == 0) return head;

        int count = size - k;

        while(count > 1){
            temp = temp.next;
            count--;
        }

        ListNode mid = temp.next;
        temp.next = null;

        ListNode tail = mid;

        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = head;

        return mid;
    }
}
