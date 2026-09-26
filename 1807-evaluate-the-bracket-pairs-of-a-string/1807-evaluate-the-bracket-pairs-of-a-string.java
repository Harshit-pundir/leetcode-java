class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();

        for(List<String> temp : knowledge){
            String key = temp.get(0);
            String value = temp.get(1);
            map.put(key,value);
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        while(i < n){
            if(s.charAt(i) != '(') sb.append(s.charAt(i));
            else{
                String temp ="";
                i++;
                while(s.charAt(i) != ')'){
                    temp += s.charAt(i);
                    i++;
                }

                if(map.containsKey(temp)) sb.append(map.get(temp));
                else sb.append("?");
                
            }i++;
        }

        return sb.toString();
    }
}