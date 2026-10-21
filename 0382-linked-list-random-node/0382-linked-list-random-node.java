class Solution {
    ArrayList<Integer> list;
    Random random;
    public Solution(ListNode head) {
        list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        random = new Random();
    }
    
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */