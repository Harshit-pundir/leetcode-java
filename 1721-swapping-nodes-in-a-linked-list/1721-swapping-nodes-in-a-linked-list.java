class Solution {
    public int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode swapNodes(ListNode head, int k) {
        int size = size(head);
        if(k > size) return head;
        if(k == size-k+1) return head;

        int first = 0;
        int second = 0;

        ListNode temp = head;

        for(int i = 0; i < size; i++){
            if(i+1 == k) first = temp.val;
            if(size-i == k) second = temp.val;

            temp = temp.next;
        }

        temp = head;

        for(int i = 0; i < size; i++){
            if(i+1 == k) {
                temp.val = second;
            }

            if(size-i == k) {
                temp.val = first;
            }

            temp = temp.next;
        }

        return head;
    }
}