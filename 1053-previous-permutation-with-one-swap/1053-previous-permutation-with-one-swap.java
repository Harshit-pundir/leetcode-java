class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;

        int i = n-1;
        while (i >= 1 && arr[i - 1] <= arr[i]) {
            i--;
        }

        if (i == 0) {
            return arr;
        }

        int j = n-1;

        while(arr[j] >= arr[i-1]) j--;
        while(arr[j] == arr[j-1]) j--;

        int temp = arr[j];
        arr[j] = arr[i-1];
        arr[i-1] = temp;

        return arr;
    }
}