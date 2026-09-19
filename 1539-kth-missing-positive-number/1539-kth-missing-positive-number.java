class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int num : arr){
            max = Math.max(num,max);
            set.add(num);
        } 
        int count = 0;
        for(int i = 1; i <= 3*max+1; i++){
            if(!set.contains(i)){
                count++;
                if(count == k) return i;
            }
        }

        return -1;
    }
}