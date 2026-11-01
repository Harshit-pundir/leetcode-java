class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;

        if(total % 2 == 1){
            return oddLength(nums1, nums2);
        }

        return evenLength(nums1, nums2);
    }

    public double oddLength(int[] a, int[] b){
        int k = (a.length + b.length) / 2 + 1;
        return kthElement(a, b, k);
    }

    public double evenLength(int[] a, int[] b){
        int k = (a.length + b.length) / 2;

        int first = kthElement(a, b, k);
        int second = kthElement(a, b, k + 1);

        return ((double)first + second) / 2;
    }

    public int kthElement(int[] a, int[] b, int k){

        if(a.length == 0) return b[k-1];
        if(b.length == 0) return a[k-1];

        int low = Math.min(a[0], b[0]);
        int high = Math.max(a[a.length-1], b[b.length-1]);

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(countBound(a, b, mid) < k){
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
