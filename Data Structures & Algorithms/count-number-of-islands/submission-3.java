/*
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
*/

record Tuple(int x, int y){}

class Solution {
    static int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        Deque<Tuple> queue = new ArrayDeque<>();
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    queue.offer(new Tuple(i,j));
                    count++;
                    while(!queue.isEmpty()){
                        Tuple t = queue.poll();
                        if(t.x >= 0 && t.x < m && t.y >=0 && t.y < n && !visited[t.x][t.y] && grid[t.x][t.y] == '1'){
                            visited[t.x][t.y] = true;
                            for(int[] d : dirs) queue.offer(new Tuple(t.x+d[0], t.y+d[1]));
                        }
                    }
                }
            }
        }

        return count;

    }
}
