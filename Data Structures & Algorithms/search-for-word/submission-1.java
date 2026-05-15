class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (foundWord(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean foundWord(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;

        if (index == word.length() - 1) return true;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean up = foundWord(board, word, i - 1, j, index + 1);
        boolean down = foundWord(board, word, i + 1, j, index + 1);
        boolean left = foundWord(board, word, i, j - 1, index + 1);
        boolean right = foundWord(board, word, i, j + 1, index + 1);

        board[i][j] = temp;

        return up || down || left || right;
    }
}
