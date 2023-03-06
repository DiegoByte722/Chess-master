import java.util.ArrayList;
import javax.swing.ImageIcon;
// -------------------------------------------------------------------------
/**
 * Class to represent the Bishop piece.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class Bishop extends ChessGamePiece{
   private static final int POSSIBLE_MOVEMENTS = 8;

public Bishop(ChessGameBoard board, int row, int col, int color) {
    super(board, row, col, color);
}

@Override
protected ArrayList<String> calculatePossibleMoves(ChessGameBoard board) {
    ArrayList<String> diagonalMoves = new ArrayList<String>();
    diagonalMoves.addAll(calculateDiagonalMoves(board, POSSIBLE_MOVEMENTS, 1, 1));
    diagonalMoves.addAll(calculateDiagonalMoves(board, POSSIBLE_MOVEMENTS, -1, 1));
    diagonalMoves.addAll(calculateDiagonalMoves(board, POSSIBLE_MOVEMENTS, 1, -1));
    diagonalMoves.addAll(calculateDiagonalMoves(board, POSSIBLE_MOVEMENTS, -1, -1));
    return diagonalMoves;
}

private ArrayList<String> calculateDiagonalMoves(ChessGameBoard board, int possibleMovements, int rowIncrement, int colIncrement) {
    ArrayList<String> diagonalMoves = new ArrayList<String>();
    int row = getRow();
    int col = getColumn();
    for (int i = 1; i <= possibleMovements; i++) {
        int newRow = row + (i * rowIncrement);
        int newCol = col + (i * colIncrement);
        if (isValidMove(board, newRow, newCol)) {
            diagonalMoves.add(getMoveAsString(newRow, newCol));
        } else {
            break;
        }
    }
    return diagonalMoves;
}

@Override
public ImageIcon createImageByPieceType() {
    switch (getColorOfPiece()) {
        case ChessGamePiece.WHITE:
            return new ImageIcon(getClass().getResource("chessImages/WhiteBishop.gif"));
        case ChessGamePiece.BLACK:
            return new ImageIcon(getClass().getResource("chessImages/BlackBishop.gif"));
        default:
            return new ImageIcon(getClass().getResource("chessImages/BlackBishop.gif"));
    }
}
}
