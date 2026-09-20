class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        int i = 0;

        
        while (i < n && arr[i] < x) {
            i++;
        }

        int j = i - 1;

        while (k > 0) {

            if (i >= n) {
                ans.add(arr[j--]);
            }
            else if (j < 0) {
                ans.add(arr[i++]);
            }
            else {
                int leftDiff = Math.abs(arr[j] - x);
                int rightDiff = Math.abs(arr[i] - x);

                if (leftDiff <= rightDiff) {
                    ans.add(arr[j--]);
                }
                else {
                    ans.add(arr[i++]);
                }
            }

            k--;
        }

        Collections.sort(ans);

        return ans;
    }
}