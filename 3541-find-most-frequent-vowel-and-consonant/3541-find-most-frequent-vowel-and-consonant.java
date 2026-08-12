class Solution {
    public int maxFreqSum(String s) {
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int vowelFreq = 0;
        int constFreq = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(vowels.contains(ch)) vowelFreq = Math.max(vowelFreq,map.get(ch));
            else constFreq = Math.max(constFreq,map.get(ch));
        }

        return constFreq + vowelFreq;
    }
}