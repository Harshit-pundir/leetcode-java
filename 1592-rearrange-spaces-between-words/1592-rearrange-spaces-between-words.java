class Solution {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        int wordCount = 0;
        char prev = ' ';

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ') spaceCount++;
            if (prev == ' ' && text.charAt(i) != ' ') wordCount++;
            prev = text.charAt(i);
        }
        if (wordCount == 1) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) != ' ') {
                    sb.append(text.charAt(i));
                }
            }

            sb.append(" ".repeat(spaceCount));

            return sb.toString();
        }

        int equalSpace = spaceCount/(wordCount-1);
        int remainSpace = equalSpace * (wordCount-1);
        int extraSpace =  spaceCount - remainSpace;

        StringBuilder sb = new StringBuilder();
        boolean firstFound = false;
        int i =0;
        while(i < text.length()){
            char ch = text.charAt(i);
            if(ch == ' ' && !firstFound){
                i++;
                 continue;
            }
            if(ch == ' ' && firstFound){
                if(remainSpace == 0 && extraSpace == 0) break;
                if(remainSpace > 0){
                    int temp = equalSpace;
                    while(temp-- > 0){
                        sb.append(' ');
                    }
                    remainSpace -= equalSpace;
                    while(i + 1 < text.length() && text.charAt(i+1) ==' ')i++;
                }else{
                   
                    while(extraSpace-- > 0){
                        sb.append(' ');
                    }
                    
                }
            }else{
                if(!firstFound) firstFound = true;
                sb.append(ch);
            }
            i++;
        }
        while(extraSpace-- > 0){
            sb.append(' ');
        }

        return sb.toString();
    }
}