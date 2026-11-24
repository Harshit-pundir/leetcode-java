class Solution {
    public int[] frequencySort(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int[][] res = new int[n][2];
        int i = 0;

        for(int num : arr){
            res[i][0] = num;
            res[i][1] = map.get(num);
            i++;
        }

        Arrays.sort(res,(a,b) -> {
            if(b[1] != a[1]) return a[1] - b[1];
            return b[0] - a[0];
        });
         i = 0;
        for(int[] a : res) ans[i++] = a[0];

        return ans;
    }
}