class Solution {
    static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];


        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(visit(i,j,m,n,grid,visited)) count++;

        return count;
    }

    private boolean visit(int x, int y, int m, int n, char[][] grid, boolean[][] visited){
        if(x >= 0 && x < m && y >=0 && y < n && !visited[x][y] && grid[x][y] == '1'){
            visited[x][y] = true;
            for(int[] d : dirs) visit(x+d[0],y+d[1],m,n,grid,visited);
            return true;
        }
        return false;
    }
}
