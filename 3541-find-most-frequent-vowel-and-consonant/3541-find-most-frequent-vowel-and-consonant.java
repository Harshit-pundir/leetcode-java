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

        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') vowelFreq = Math.max(vowelFreq,freq[ch-'a']);
            else constFreq = Math.max(constFreq , freq[ch-'a']);
        }

        return constFreq + vowelFreq;
    }
}