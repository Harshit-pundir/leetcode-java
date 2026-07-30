class Solution {
    public int magicalString(int n) {

        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] magic = new int[n + 2];

        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;

        int head = 2;   // read pointer
        int tail = 3;   // write pointer
        int num = 1;    // next number to append
        int count = 1;  // first 3 elements me sirf ek '1' hai

        while (tail < n) {

            int repeat = magic[head];

            while (repeat-- > 0 && tail < n) {
                magic[tail] = num;

                if (num == 1)
                    count++;

                tail++;
            }

            num = (num == 1) ? 2 : 1; // alternate 1 and 2
            head++;
        }

        return count;
    }
}