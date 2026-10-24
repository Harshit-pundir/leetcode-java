class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(convert(date1) - convert(date2));
    }

    public int convert(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int total = year * 365 + day;

        for (int i = 1; i < year; i++) {
            if (i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)) {
                total++;
            }
        }

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < month; i++) {
            total += days[i - 1];
        }

        if (month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            total++;
        }

        return total;
    }
}