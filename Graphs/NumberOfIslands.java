//? Leetcode Problem: 200 - Number of Islands
//? Difficulty: 'Medium'
//? Description:
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

//? Examples:

//? Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

//?Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

//? Solution Notes:
//* Extremely Important Problem
    //* Handles 2D array like a GRAPH
    //* Utilizes Connected-Components Logic (DFS on unvisited)

public class NumberOfIslands{
    int islandCount = 0;

    public int numIslands(char[][] grid) {
        // Row & Column Constants
        int ROW = grid.length;
        int COL = grid[0].length;

        boolean[][] visited = new boolean[ROW][COL];
        boolean encounteredIsland = false;

        // Connected Components Concept
        // -Except, increment 'count' in the helper function.
        // -dfs initialy at 0,0. then for each not yet visited coordinate.
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (!visited[r][c])
                    dfsIsland(r, c, encounteredIsland, grid, visited, ROW, COL);
            }
        }

        return islandCount;
    }

    public void dfsIsland(int row, int col, boolean encounteredIsland, char[][] grid, boolean[][] visited, int ROW,
            int COL) {
        if (row >= ROW || col >= COL || row < 0 || col < 0 || visited[row][col])
            return;
        visited[row][col] = true;
        if (grid[row][col] == '0')
            return;
        if (!encounteredIsland)
            islandCount++;
        encounteredIsland = true;
        dfsIsland(row, col + 1, encounteredIsland, grid, visited, ROW, COL);
        dfsIsland(row + 1, col, encounteredIsland, grid, visited, ROW, COL);
        dfsIsland(row - 1, col, encounteredIsland, grid, visited, ROW, COL);
        dfsIsland(row, col - 1, encounteredIsland, grid, visited, ROW, COL);
    }
}