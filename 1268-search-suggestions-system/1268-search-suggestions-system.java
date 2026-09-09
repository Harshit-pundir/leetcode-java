class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> ans = new ArrayList<>();

        String prefix = "";

        for(char ch : searchWord.toCharArray()) {
            prefix += ch;

            int index = binarySearch(products, prefix);

            List<String> temp = new ArrayList<>();

            for(int i = index; i < products.length && temp.size() < 3; i++) {
                if(products[i].startsWith(prefix)) {
                    temp.add(products[i]);
                } else {
                    break;
                }
            }

            ans.add(temp);
        }

        return ans;
    }

    public int binarySearch(String[] products, String prefix) {
        int low = 0;
        int high = products.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(products[mid].compareTo(prefix) >= 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}