public class _0NumberOfIslands {
    private static void islands_dfs(char[][] graph, int x, int y) {
        graph[x][y] = '0';
        for(int d = 0; d < 4; d++) {
            int r = x + xdir[d];
            int c = y + ydir[d];
            if(r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] != '0') {
                islands_dfs(graph, r, c);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    islands_dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
}
