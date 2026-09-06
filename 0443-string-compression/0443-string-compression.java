class Solution {
    public int compress(char[] chars) {
        char lastChar = chars[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < chars.length; i++){
            if(lastChar != chars[i]){
                sb.append(lastChar);
                if(count != 1) sb.append(count);
                lastChar = chars[i];
                count = 1;
            }else{
                count++;
            }
        }
        sb.append(lastChar);
        if(count != 1) sb.append(count);

        for(int i = 0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}