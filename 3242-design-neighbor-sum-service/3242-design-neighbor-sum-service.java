class NeighborSum {

    int[][] grid;
    int n;
    int m;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
    }
    
    public int adjacentSum(int value) {

        int r = 0, c = 0;

        // value ki position find karo
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == value) {
                    r = i;
                    c = j;
                }
            }
        }

        int sum = 0;

        // Up
        if(r - 1 >= 0)
            sum += grid[r - 1][c];

        // Down
        if(r + 1 < n)
            sum += grid[r + 1][c];

        // Left
        if(c - 1 >= 0)
            sum += grid[r][c - 1];

        // Right
        if(c + 1 < m)
            sum += grid[r][c + 1];

        return sum;
    }
    
    public int diagonalSum(int value) {

        int r = 0, c = 0;

        // value ki position find karo
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == value) {
                    r = i;
                    c = j;
                }
            }
        }

        int sum = 0;

        // Top-left
        if(r - 1 >= 0 && c - 1 >= 0)
            sum += grid[r - 1][c - 1];

        // Top-right
        if(r - 1 >= 0 && c + 1 < m)
            sum += grid[r - 1][c + 1];

        // Bottom-left
        if(r + 1 < n && c - 1 >= 0)
            sum += grid[r + 1][c - 1];

        // Bottom-right
        if(r + 1 < n && c + 1 < m)
            sum += grid[r + 1][c + 1];

        return sum;
    }
}