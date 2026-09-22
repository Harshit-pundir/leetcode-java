class Solution {
    int[] arr;
    int total;

    public Solution(int[] w) {
        arr = new int[w.length];

        total = 0;

        for(int i = 0; i < w.length; i++){
            total += w[i];
            arr[i] = total;
        }
    }

    public int pickIndex() {
        int random = (int)(Math.random() * total) + 1;

        for(int i = 0; i < arr.length; i++){
            if(random <= arr[i]){
                return i;
            }
        }

        return -1;
    }
}