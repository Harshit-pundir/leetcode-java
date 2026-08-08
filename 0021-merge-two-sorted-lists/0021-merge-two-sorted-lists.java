class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode dummy = new ListNode(0);
        ListNode d1 = dummy;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                d1.next = l1;
                l1 = l1.next;
            }else{
                d1.next = l2;
                l2 = l2.next;
            }

            d1 = d1.next;
        }
        while(l1 != null){
            d1.next = l1;
            l1 = l1.next;
            d1 = d1.next;
        }

        while(l2 != null){
            d1.next = l2;
            l2 = l2.next;
            d1 = d1.next;
        }

        return dummy.next;
    }
}