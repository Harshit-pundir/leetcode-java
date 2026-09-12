class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int i =0;

        while(i < s.length()){
            StringBuilder sb = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' '){
                sb.append(s.charAt(i));
                i++;
            }
            words.add(sb.reverse().toString());
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(i = 0; i <words.size(); i++){
            sb.append(words.get(i));
            if(i != words.size()-1) sb.append(' ');
        }

        return sb.toString();
    }
}