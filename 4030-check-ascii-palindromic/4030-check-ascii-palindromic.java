class Solution {
    public boolean isPal(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            int ascii = (int) ch;
            String binary = String.format("%8s" , Integer.toBinaryString(ascii)).replace(' ','0');
            sb.append(binary);
        }

        int i =0;
        int j = sb.length()-1;
        while(i < j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
    public boolean isPalindromic(String s) {
        return isPal(s);
    }
}