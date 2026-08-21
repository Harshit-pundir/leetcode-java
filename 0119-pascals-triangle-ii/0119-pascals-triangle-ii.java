class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long val = 1;
        row.add(1); // First element is always 1

        for (int i = 1; i <= rowIndex; i++) {
            // Compute next value using previous value (nCr = nC(r-1) * (n - r + 1)/r)
            val = val * (rowIndex - i + 1) / i;
            row.add((int) val);
        }

        return row;
    }
    }
