package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class represents the Model component for Tic Tac Toe game implemented by a 2D array. This
 * model knows methods including move, getTurn, isOver, getWinner, etc.
 */
public class TicTacToeModel implements TicTacToe {
  private final Player[][] boardMatrix;
  private int moveCount;

  /**
   * Constructs a TicTacToe model with initialized empty board and moveCount.
   */
  public TicTacToeModel() {
    this.boardMatrix = new Player[3][3];
    this.moveCount = 0;
  }

  @Override
  public void move(int r, int c) throws IllegalArgumentException, IllegalStateException {
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Invalid position, out of board.");
    }
    if (getMarkAt(r, c) != null) {
      throw new IllegalArgumentException("This position is occupied.");
    }
    if (isGameOver()) {
      throw new IllegalStateException("The game is over.");
    }
    this.boardMatrix[r][c] = getTurn();
    this.moveCount += 1;
  }

  @Override
  public Player getTurn() {
    if (isGameOver()) {
      return null;
    }
    if (this.moveCount % 2 == 0) {
      return Player.X;
    } else {
      return Player.O;
    }
  }

  @Override
  public boolean isGameOver() {
    return (this.moveCount == 9 || getWinner() != null);
  }

  @Override
  public Player getWinner() {
    for (int i = 0; i < 3; i++) {
      if (boardMatrix[i][0] == boardMatrix[i][1] && boardMatrix[i][1] == this.boardMatrix[i][2]) {
        return boardMatrix[i][0];
      } else if (boardMatrix[0][i] == boardMatrix[1][i]
          && boardMatrix[1][i] == this.boardMatrix[2][i]) {
        return boardMatrix[0][i];
      }
    }
    if (boardMatrix[0][0] == boardMatrix[1][1] && boardMatrix[1][1] == boardMatrix[2][2]) {
      return boardMatrix[0][0];
    } else if (boardMatrix[0][2] == boardMatrix[1][1] && boardMatrix[1][1] == boardMatrix[2][0]) {
      return boardMatrix[0][2];
    } else {
      return null;
    }
  }

  @Override
  public Player[][] getBoard() {
    Player[][] copyOfBoard = new Player[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        copyOfBoard[i][j] = this.boardMatrix[i][j];
      }
    }
    return copyOfBoard;
  }

  @Override
  public Player getMarkAt(int r, int c) throws IllegalArgumentException {
    if (r < 0 || c < 0 || r > 2 || c > 2) {
      throw new IllegalArgumentException("Invalid position, out of board.");
    }
    return this.boardMatrix[r][c];
  }

  @Override
  public String toString() {
    // Using Java stream API to save code:
    return Arrays.stream(getBoard()).map(
      row -> " " + Arrays.stream(row).map(
        p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
          .collect(Collectors.joining("\n-----------\n"));
    /*
  This is the equivalent code as above, but using iteration, and still using
  the helpful built-in String.join method.
  List<String> rows = new ArrayList<>();
  for(Player[] row : getBoard()) {
  List<String> rowStrings = new ArrayList<>();
  for(Player p : row) {
  if(p == null) {
  rowStrings.add(" ");
  } else {
  rowStrings.add(p.toString());
  }
   }
  rows.add(" " + String.join(" | ", rowStrings));
  }
  return String.join("\n-----------\n", rows);
 */
  }
}

