class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();



        for(String word : arr){
            if(word.equals("") || word.equals(".")){
                continue;
            }else{
                if(word.equals("..")){
                    if(!st.isEmpty()) st.pop();
                }else{
                    st.push(word);
                }
            }
        }

        while(!st.isEmpty()){
            sb.insert(0,"/"+st.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
        
    }
}