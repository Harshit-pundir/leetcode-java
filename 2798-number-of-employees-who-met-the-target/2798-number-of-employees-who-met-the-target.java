class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        Arrays.sort(hours);
        int low = 0;
        int high = hours.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(hours[mid] < target) low = mid+1;
            else high = mid-1;
        }

        return hours.length-low;
    }
}