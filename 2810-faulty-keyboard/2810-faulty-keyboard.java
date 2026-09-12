class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == 'i' ){
                if(!sb.isEmpty())
                    sb.reverse();
            }
            else sb.append(ch);
        }

        return sb.toString();
    }
}