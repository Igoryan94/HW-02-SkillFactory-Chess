class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        if (line == toLine && column == toColumn) return false;
//        if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0) return false;

        /*return (line - toLine == 1 && column - toColumn == 1)
                || (toLine - line == 1 && toColumn - column == 1)
                || (toLine - line == 1 && column - toColumn == 1)
                || (line - toLine == 1 && toColumn - column == 1);*/
//        return Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1;

        //<editor-fold desc="Code taken from the source...">
        // check that we can move to position and can't moved out from board or in not empty position
        if (line != toLine && column != toColumn &&
                getMax(line, toLine) - getMin(line, toLine) == getMax(column, toColumn) - getMin(column, toColumn) &&
                checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                chessBoard.board[line][column] != null) {
            if (!chessBoard.board[line][column].equals(this)) {
                return false;
            }

            // from up-left to down-right
            if ((column == getMin(column, toColumn) && line == getMax(line, toLine)) ||
                    (toColumn == getMin(column, toColumn) && toLine == getMax(line, toLine))) {
                int fromL = getMax(line, toLine);
                int fromC = getMin(column, toColumn);
                int toL = getMin(line, toLine);
                int toC = getMax(column, toColumn);
                int[][] positions = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++) {
                    if (chessBoard.board[fromL - i][fromC + i] == null) {
                        positions[i - 1] = new int[]{fromL - i, fromC + i};
                    } else if (!chessBoard.board[fromL - i][fromC + i].color.equals(this.color) && fromL - i == toLine) {
                        positions[i - 1] = new int[]{fromL - i, fromC + i};
                    } else {
                        return false;
                    }
                }
                return true;
            } else {
                // from down-left to up-right
                int fromL = getMin(line, toLine);
                int fromC = getMin(column, toColumn);
                int toL = getMax(line, toLine);
                int toC = getMax(column, toColumn);
                int[][] positions = new int[toC - fromC][1];
                for (int i = 1; i < toC - fromC; i++) {
                    if (chessBoard.board[fromL + i][fromC + i] == null) {
                        positions[i - 1] = new int[]{fromL + i, fromC + i};
                    } else if (!chessBoard.board[fromL + i][fromC + i].color.equals(this.color) && fromL + i == toLine) {
                        positions[i - 1] = new int[]{fromL + i, fromC + i};
                    } else {
                        return false;
                    }
                }
                return true;
            }
        } else return false;
        //</editor-fold>
    }

    //<editor-fold desc="Code taken from the source...">
    public String getSymbol() {
        return "B";
    }

    public int getMax(int a, int b) {
        return Math.max(a, b);
    }

    public int getMin(int a, int b) {
        return Math.min(a, b);
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }
    //</editor-fold>
}