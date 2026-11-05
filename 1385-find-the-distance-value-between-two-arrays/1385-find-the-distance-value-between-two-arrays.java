class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for(int num : arr1){
            boolean isValid = true;
            for(int val : arr2){
                if(Math.abs(num - val) <= d){
                    isValid = false;
                    break;
                }
            }
            if(isValid) count++;
        }

        return count;
    }
}