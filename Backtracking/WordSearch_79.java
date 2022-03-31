class WordSearch_79{
    public boolean exist(char[][] board, String word) {
        //* Initialization of Data
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] positionSet = new boolean[ROWS][COLS];

        //* Selects each cell as an origin for the dfs() call.
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                //* if ever true, return true. Don't want to return the dfs as it may return only the first instance at cell[0][0]
                if (dfs(r, c, 0, board, word, positionSet, ROWS, COLS))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i, char[][] board, String word, boolean[][] positionSet, int ROWS, int COLS) {
        //* Base Cases
        if (i == word.length())
            return true;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || word.charAt(i) != board[r][c] || positionSet[r][c])
            return false;

        //* Add to visited set on way down
        positionSet[r][c] = true;
        boolean result = dfs(r + 1, c, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r - 1, c, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r, c + 1, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r, c - 1, i + 1, board, word, positionSet, ROWS, COLS);
        
        //* Remove from visited set on way up. Clears for next origin.
        positionSet[r][c] = false;

        return result;
    }
}