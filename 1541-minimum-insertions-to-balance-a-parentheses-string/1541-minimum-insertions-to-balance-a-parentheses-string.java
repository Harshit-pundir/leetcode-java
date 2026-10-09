class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int i = 0;
        int n = s.length();
        int leftCount = 0;

        while(i < n){
            char ch = s.charAt(i);

            if(ch == '('){
                leftCount++;
                i++;
            }else{
                if(leftCount > 0) leftCount--;
                else insertions++;

                if(i < n-1 && s.charAt(i+1) ==')') i += 2;
                else{
                    insertions++;
                    i++;
                }
            }
        }

        insertions += leftCount * 2;
        return insertions;
    }
}