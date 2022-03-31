class WordSearch_79{
    public boolean exist(char[][] board, String word) {
        // Initialization of Data
        int ROWS = board.length;
        int COLS = board[0].length;
        boolean[][] positionSet = new boolean[ROWS][COLS];

        //Selects each cell as an origin for the dfs() call.
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r, c, 0, board, word, positionSet, ROWS, COLS))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i, char[][] board, String word, boolean[][] positionSet, int ROWS, int COLS) {
        if (i == word.length())
            return true;
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || word.charAt(i) != board[r][c] || positionSet[r][c])
            return false;
        positionSet[r][c] = true;
        boolean result = dfs(r + 1, c, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r - 1, c, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r, c + 1, i + 1, board, word, positionSet, ROWS, COLS)
                || dfs(r, c - 1, i + 1, board, word, positionSet, ROWS, COLS);
        positionSet[r][c] = false;

        return result;
    }
}