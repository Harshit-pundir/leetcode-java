class Solution {
    public long countVowels(String word) {
        long count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int n = word.length();

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int left = 0;
        for(int right = 0; right < n; right++){
            char ch = word.charAt(right);
            if(set.contains(ch)) count += (long)(right + 1) * (n - right);

        }
        return count;
    }
}