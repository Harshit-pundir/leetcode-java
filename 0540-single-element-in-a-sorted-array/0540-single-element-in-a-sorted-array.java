class Solution {
    public int singleNonDuplicate(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
 
        while (low < high) {
           
            int mid = low + (high - low) / 2;
 
            if (mid % 2 == 1) {
                mid--;
            }
 
            if (arr[mid] == arr[mid + 1]) {
                low = mid + 2;
            } else {
                
                high = mid;
            }
        }
 
        return arr[low];
    }
}
 