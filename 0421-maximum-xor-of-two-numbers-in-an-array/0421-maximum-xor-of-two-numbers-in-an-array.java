class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    TrieNode root = new TrieNode();
    public void insert(int num){
        TrieNode curr = root;

        for(int i = 31; i>=0; i--){
            int bit = (num >> i) & 1;

            if(curr.children[bit] == null){
                curr.children[bit] = new TrieNode();
            }
            curr = curr.children[bit];
        }

    }

    public int getMaxXor(int num){
        TrieNode curr = root;
        int xor = 0;

        for(int i = 31; i>= 0; i--){
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if(curr.children[opposite] != null){
                xor |= (1 << i);
                curr = curr.children[opposite];
            }else{
                curr = curr.children[bit];
            }
        }

        return xor;
    }
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int ans = 0;

        for (int num : nums) {
            ans = Math.max(ans, getMaxXor(num));
        }

        return ans;
    }
}