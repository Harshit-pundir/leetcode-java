class Solution {

    public void solve(int idx, String digits, HashMap<Integer,String> map,
                      String res, List<String> ans) {

        if(idx == digits.length()){
            ans.add(res);
            return;
        }

        int num = digits.charAt(idx) - '0';
        String str = map.get(num);

        for(int i = 0; i < str.length(); i++){
            solve(idx + 1, digits, map, res + str.charAt(i), ans);
        }
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0) return new ArrayList<>();

        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> ans = new ArrayList<>();

        solve(0, digits, map, "", ans);

        return ans;
    }
}
