class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    public String getColor() {
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (toLine > 7 || toColumn > 7 || toLine < 0 || toColumn < 0) return false;

        return (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1)
                || (Math.abs(column - toColumn) == 2 && Math.abs(line - toLine) == 1);
    }

    public String getSymbol() {
        return "H";
    }
}