
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if(total % 2 == 1){
            return oddLength(nums1, nums2);
        }

        return evenLength(nums1, nums2);
    }

    public double oddLength(int[] a, int[] b){
        int required = (a.length + b.length) / 2;
        return binarySearch(a, b, required);
    }

    public double evenLength(int[] a, int[] b){
        int required = (a.length + b.length) / 2;

        int second = binarySearch(a, b, required);
        int first = binarySearch(a, b, required - 1);

        return ((double)first + second) / 2;
    }

    public int binarySearch(int[] a, int[] b, int required){
        int n = a.length;
        int m = b.length;

        if(n == 0) return b[required];
        if(m == 0) return a[required];

        int low = Math.min(a[0], b[0]);
        int high = Math.max(a[n-1], b[m-1]);

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(countBound(a, b, mid) <= required){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }

    public int countBound(int[] a, int[] b, int mid){
        return upperBound(a, mid) + upperBound(b, mid);
    }

    public int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }
}
