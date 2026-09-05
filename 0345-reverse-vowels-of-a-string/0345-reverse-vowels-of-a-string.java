class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        HashSet<Character> v = new HashSet<>();

        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};

        for(char c : vowels){
            v.add(c);
        }

        char[] arr = s.toCharArray();

        while(i < j){
            char ch = arr[i];
            char ch2 = arr[j];
            if(ch == ch2){
                i++;
                j--;
                continue;
            }

            if(v.contains(ch) && v.contains(ch2)){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
            else if(!v.contains(ch)){
                i++;
            }
            else{
                j--;
            }
        }

        return new String(arr);
    }
}