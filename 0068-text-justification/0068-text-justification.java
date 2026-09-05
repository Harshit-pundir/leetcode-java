class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int n = words.length;

        List<String> ans = new ArrayList<>();

        while (i < n) {

            List<String> list = new ArrayList<>();

            int currentLength = 0;
            int wordsLength = 0;

            // Find maximum words that can fit
            while (i < n &&
                   currentLength + words[i].length()
                   + (currentLength == 0 ? 0 : 1)
                   <= maxWidth) {

                if (currentLength != 0) {
                    currentLength++;
                }

                currentLength += words[i].length();
                wordsLength += words[i].length();

                list.add(words[i]);
                i++;
            }

            StringBuilder sb = new StringBuilder();

            // Last line OR single word line
            if (i == n || list.size() == 1) {

                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));

                    if (j != list.size() - 1) {
                        sb.append(" ");
                    }
                }

                sb.append(" ".repeat(maxWidth - sb.length()));

                ans.add(sb.toString());
            }

            // Fully justified line
            else {

                int spaces = maxWidth - wordsLength;
                int gaps = list.size() - 1;

                int equalSpace = spaces / gaps;
                int extraSpace = spaces % gaps;

                for (int j = 0; j < list.size(); j++) {

                    sb.append(list.get(j));

                    if (j < list.size() - 1) {

                        sb.append(" ".repeat(equalSpace));

                        // Left gaps get extra spaces
                        if (j < extraSpace) {
                            sb.append(" ");
                        }
                    }
                }

                ans.add(sb.toString());
            }
        }

        return ans;
    }
}