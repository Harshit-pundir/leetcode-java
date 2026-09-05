class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String> words = new ArrayList<>();
        int i =0;
        int n = s.length();
        while(i < n){
            StringBuilder sb = new StringBuilder();
            if(i + k -1 < n){
                int temp = k;
                while(temp-- > 0){
                    sb.append(s.charAt(i));
                    i++;
                }
            }else{
                int temp = k;
                while(i < n){
                    sb.append(s.charAt(i));
                    i++;
                    temp--;
                    
                }

                while(temp-- > 0){
                    sb.append(fill);
                }
            }

            words.add(sb.toString());
        }

        return words.toArray(new String[0]);
    }
}