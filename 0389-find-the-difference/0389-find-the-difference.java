class Solution { 
    public char findTheDifference(String s, String t) { 
        char[] arr = s.toCharArray(); 
        char[] arr2 = t.toCharArray(); 
        
        Arrays.sort(arr); 
        Arrays.sort(arr2); 
        
        int i = 0; 
        
        for(char ch : arr){ 
            if(ch != arr2[i]) return arr2[i]; 
            i++;
        } 
        
        return arr2[i]; 
    } 
}