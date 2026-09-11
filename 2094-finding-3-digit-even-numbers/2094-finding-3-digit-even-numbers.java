class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        int n = digits.length;

        for(int i =0; i < n ; i++){
            if(digits[i] == 0) continue;
            for(int j = 0 ; j < n; j++){
                if(j == i) continue;
                for(int k = 0; k < n; k++){
                    if(k == i || k == j) continue;
                    if(digits[k] % 2 == 0){
                        StringBuilder sb = new StringBuilder();
                        sb.append(digits[i]);
                        sb.append(digits[j]);
                        sb.append(digits[k]);
                        
                        int num = Integer.parseInt(sb.toString());
                        set.add(num);
                    }
                }
            }
        }
        int[] ans = new int[set.size()];
        int i =0;
        for(int num : set) ans[i++] = num;
        Arrays.sort(ans);
        return ans;
    }
}