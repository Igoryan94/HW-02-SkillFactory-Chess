class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0) return false;

        //<editor-fold desc="Code taken from the source...">
        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        }
        //</editor-fold>

        return (Math.abs(line - toLine) == 1 && column == toColumn)
                || (Math.abs(column - toColumn) == 1 && line == toLine);
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (line <= 7 && column <= 7 && line >= 0 && column >= 0) {
            //<editor-fold desc="Code taken from the source...">
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
            //</editor-fold>
        } else return false;
    }

    public String getSymbol() {
        return "K";
    }
}