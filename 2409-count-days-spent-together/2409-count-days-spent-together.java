class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int a1 = days[Integer.parseInt(arriveAlice.substring(0, 2)) - 1]
               + Integer.parseInt(arriveAlice.substring(3));

        int a2 = days[Integer.parseInt(leaveAlice.substring(0, 2)) - 1]
               + Integer.parseInt(leaveAlice.substring(3));

        int b1 = days[Integer.parseInt(arriveBob.substring(0, 2)) - 1]
               + Integer.parseInt(arriveBob.substring(3));

        int b2 = days[Integer.parseInt(leaveBob.substring(0, 2)) - 1]
               + Integer.parseInt(leaveBob.substring(3));

        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);

        return Math.max(0, end - start + 1);
    }
}