class Solution {
    class Pair{
        int num;
        int den;
        double frac;

        Pair(int num , int den , double frac){
            this.num = num;
            this.den = den;
            this.frac = frac;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(a.frac, b.frac));

        for(int i =0; i < arr.length-1; i++){
            for(int j = i + 1; j < arr.length; j++){
                pq.add(new Pair(arr[i] , arr[j] , (double)arr[i]/arr[j]));
            }
        }

        while(!pq.isEmpty() && k-- > 1){
            pq.poll();
        }

        Pair curr = pq.poll();
        return new int[]{curr.num,curr.den};

    }
}