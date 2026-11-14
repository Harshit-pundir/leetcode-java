class Solution {
    public ListNode reverseNode(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = reverseNode(slow);
        slow = head;
        while(mid != null){
            if(slow.val != mid.val) return false;
            slow = slow.next;
            mid = mid.next;
        }
        return true;
    }
}